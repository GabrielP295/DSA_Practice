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
    /*
    Input: head of singly linked list
    Output: head of reversed input list
    - The list may be empty
    Ex. null [1, 5, 3, 6] null ->
    null -> [5 -> 1] null

    Approach:
    - storing previous node to set the current nodes next pointer to the previous
    - temporarily store the next node before changing current so we can iterate
     */
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode currentNext = current.next;
            current.next = previous;
            previous = current;
            current = currentNext;
        }

        return previous;
    }
}