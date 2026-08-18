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
    public boolean isValidBST(TreeNode root) {
        T ans = f(root);
        return ans.res;

        
    }


    T f(TreeNode root) {
        
        T t = new T();
        t.mx = Integer.MIN_VALUE;
        t.mn = Integer.MAX_VALUE;
        t.res = true;
        if (root == null) {
            return t;
        }

        T l = f(root.left);
        if (!l.res || l.mx >= root.val) {
            t.res = false;
            return t;

        }
        T r = f(root.right);
        if (!r.res || r.mn <= root.val) {
            t.res = false;
            return t;

        }

        t.mx = Math.max(root.val, r.mx);
        t.mn = Math.min(root.val, l.mn);
        return t;
    }

    class T {
        int mx;
        int mn;
        boolean res;
    }
}
