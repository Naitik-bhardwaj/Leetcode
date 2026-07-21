class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        int ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') ones++;
        }

        List<Integer> len = new ArrayList<>();
        List<Character> type = new ArrayList<>();

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;

            type.add(s.charAt(i));
            len.add(j - i);

            i = j;
        }

        int maxGain = 0;

        for (int k = 1; k + 1 < len.size(); k++) {
            if (type.get(k) == '1'
                    && type.get(k - 1) == '0'
                    && type.get(k + 1) == '0') {

                maxGain = Math.max(
                        maxGain,
                        len.get(k - 1) + len.get(k + 1)
                );
            }
        }

        return Math.min(n, ones + maxGain);
    }
}