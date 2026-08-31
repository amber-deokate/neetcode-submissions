// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */

// class Solution {
//     Map<Integer, Integer> map = new HashMap<>();
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         int n = preorder.length;
        
//         for (int i = 0; i < n; i++) {
//             map.put(inorder[i], i);
//         }

//         return f(preorder, 0, n - 1, inorder, 0, n - 1);
//     }

//     TreeNode f(int[] preorder, int i, int j, int[] inorder, int x, int y) {
//         if (i > j) {
//             return null;
//         }
//         if (i == j) {
//             return new TreeNode(preorder[i]);
//         }
//         int idx = map.get(preorder[i]);
//         int lenLeft = idx - x;
//         int lenRight = y - idx;
//         TreeNode res = new TreeNode(preorder[i]);
//         TreeNode l = f(preorder, i + 1, i + 1 + lenLeft - 1, inorder, x, idx - 1);
//         TreeNode r = f(preorder, j - lenRight + 1, j, inorder, idx + 1, y);
//         res.left = l;
//         res.right = r;
//         return res;

//     }
// }

class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = inorderMap.get(rootVal);

        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}
