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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        f(result, 0, root);
        return result;

    }
    void f(List<Integer> result, int index, TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (index == result.size()) {
            result.add(root.val);
        }
        f(result, index + 1, root.right);
        f(result, index + 1, root.left);
    }
}
