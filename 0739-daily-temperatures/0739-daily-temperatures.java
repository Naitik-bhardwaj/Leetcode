import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>(); // index store karega

        for (int i = 0; i < n; i++) {

            // jab tak current temp > stack top temp
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int prevIndex = st.pop();
                ans[prevIndex] = i - prevIndex;
            }

            // current index stack me daal do
            st.push(i);
        }

        // jo stack me bache unka answer default 0 hi rahega
        return ans;
    }
}