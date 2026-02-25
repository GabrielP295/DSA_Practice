/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        /*
        Input: linked list starting at the head node
        Output: boolean if there's a cycle, a node in the list can be visited again
        if a node is pointed to more than once, cycle exists
        length of list can be 0

        -traverse list -> use a hashset 
        -check if seen listnode already, if we have then linked cycle exists
        -keep traversing until next pointer null, or next pointer is node already seen
        */

        ListNode currentNode = head;
        Set<ListNode> nodesSeen = new HashSet<>();
        while (currentNode != null) {
            nodesSeen.add(currentNode);
            if (currentNode.next == null) {
                return false;
            }
            currentNode = currentNode.next;
            if (nodesSeen.contains(currentNode)) return true;
        }

        return false;
    }
}
