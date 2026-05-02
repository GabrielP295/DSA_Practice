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
    Input: linked list of numbers
    Output: linked list -> [0, n-1, 1, n-2...]
    Ex: [0, 1] -> [0, 1] 
    [0, 1, 2] -> [0, 2, 1]
    {
    index: node
    1: node(1)
    2: node(2)
    }
    
    Approach:
    - Every other number after the first becomes n - iteration
    - The other numbers that aren't n - i, get pushed forward 1
    - Iteration becomes actual iteration / 2
    - Iterate through list to populate hashmap with index(key) and nodes(value)
    - Iterate again to reorder the list using the hashmap
    - Grab n - iteration from map, point its next pointer to the node that was originally there
    - In the same iteration change the current nodes next with new node, but save the next in a temp to assing
    new node's next value with that temp
    - Iterate linked list by 2, to avoid the n - iteration 
    */
    public void reorderList(ListNode head) {
        Map<Integer, ListNode> indexToNode = new HashMap<>();
        int index = 0;
        ListNode currentNode = head;

        while (currentNode != null) {
            indexToNode.put(index, currentNode);
            currentNode = currentNode.next;
            index++;
        }

        currentNode = head;
        while (currentNode.next != null || currentNode != null) {
            ListNode tempNext = currentNode.next;
            ListNode newNode = indexToNode.get(index - 1);
            index--;
            currentNode.next = newNode;
            newNode.next = tempNext;
            currentNode = currentNode.next.next;
        }
    }
}
