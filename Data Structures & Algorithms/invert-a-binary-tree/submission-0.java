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
    Input: root of a binary tree
    Output: the root of the input binary tree inverted
    - inverted tree means that for every node, it's left and right values are swapped
    - swaps using null childs still need to be accounted for
    
    Approach:
    - recursively swap at each node for the left and right branches
    - base case is when current node == null
     */
    
    private TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}
