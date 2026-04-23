/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /*
    Input: root of binary tree
    Output: depth of binary tree (# of nodes along longest path)
    Constraints: If there's a tie, just return that number

    Approach:
    - Brute force approach to visit every single node at least once
    - Keep track of the longest path of nodes that we have come across
    */
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;

        maxDepth = Math.max(findDepth(root, maxDepth), maxDepth);

        return maxDepth;
    }

    public int findDepth(TreeNode node, int depth) {
        if (node == null) return 0;
        depth += 1;
        findDepth(node.left, depth);
        findDepth(node.right, depth);
        return depth;
    }
}
