/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode start = new ListNode(0);
        ListNode output = start;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                output.next = list2;
                list2 = list2.next;
            }
            else {
                output.next = list1;
                list1 = list1.next;
            }
            output = output.next;
        }

        ListNode next = list1 == null ? list2 : list1;
        output.next = next;

        return start.next;
    }
}