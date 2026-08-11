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
    Map<TreeNode, Integer> hm = new HashMap<>();

    int h(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (hm.containsKey(root)) {
            return hm.get(root);
        }

        int l = h(root.left);
        int r = h(root.right);

        int ans = Math.max(l, r) + 1;
        hm.put(root, ans);
        return ans;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = h(root.left);
        int r = h(root.right);

        if (Math.abs(l - r) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
        
    }
}
