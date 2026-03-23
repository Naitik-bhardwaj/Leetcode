1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode reverseList(ListNode head) {
13        Stack<Integer> valueStack = new Stack<>();
14        while(head != null){
15            valueStack.push(head.val);
16            head = head.next;
17        }
18        ListNode reversedList = new ListNode(Integer.MIN_VALUE);
19        ListNode ptr = reversedList;
20        while(!valueStack.isEmpty()){
21            ptr.next = new ListNode(valueStack.pop());
22            ptr = ptr.next;
23        }
24        return reversedList.next;
25    }
26}