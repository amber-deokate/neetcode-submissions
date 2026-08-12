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
    // HashMap<TreeNode, Boolean> hm = new HashMap<>();

    // boolean f(TreeNode root, TreeNode p) {
    //     if (root == null) {
    //         return false;
    //     }
    //     if (root.val == p.val) {
    //         return true;
    //     }
    //     return f(root.left, p) || f(root.right, p);


    // }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if (root.val == p.val || root.val == q.val) {
        //     return root;
        // }
        // if (f(root.left, p) && f(root.left, q)) {
        //     return lowestCommonAncestor(root.left, p, q);

        // } if (f(root.right, p) && f(root.right, q)) {
        //     return lowestCommonAncestor(root.right, p, q);

        // } else {
        //     return root;
        // }

        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;

            } else {
                return root;
            }

        }
        return null;
        
    }
}
