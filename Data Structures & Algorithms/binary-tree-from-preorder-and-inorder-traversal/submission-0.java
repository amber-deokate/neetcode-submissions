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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return f(preorder, 0, n - 1, inorder, 0, n - 1);
        
    }


    TreeNode f(int[] preorder, int i, int j, int[] inorder, int x, int y) {

        if (i > j) {
            return null;
        }

        if (i == j) {
            return new TreeNode(preorder[i]);
        }

        int mid = preorder[i];
        int idx = -1;
        for (int k = x; k <= y; k++) {
            if (inorder[k] == mid) {
                idx = k;
            }
        }
        int lenLeft = idx - x;
        int lenRight = y - idx;
        TreeNode res = new TreeNode(preorder[i]);
        TreeNode l = f(preorder, i + 1, i + 1 + lenLeft - 1, inorder, x, idx - 1);
        TreeNode r = f(preorder, j - lenRight + 1, j, inorder, idx + 1, y);
        res.left = l;
        res.right = r;
        return res;

    }




}
