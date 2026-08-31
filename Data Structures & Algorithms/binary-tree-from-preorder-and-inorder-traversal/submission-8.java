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
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        int[] preorderIndex = {0};
        
        return build(preorder, 0, inorder.length - 1, inorderMap, preorderIndex);
    }
    
    private TreeNode build(int[] preorder, int inStart, int inEnd, Map<Integer, Integer> inorderMap, int[] preorderIndex) {
        if (inStart > inEnd) {
            return null;
        }
        
        int rootVal = preorder[preorderIndex[0]++];
        TreeNode root = new TreeNode(rootVal);
        
        int inIndex = inorderMap.get(rootVal);
        
        root.left = build(preorder, inStart, inIndex - 1, inorderMap, preorderIndex);
        root.right = build(preorder, inIndex + 1, inEnd, inorderMap, preorderIndex);
        
        return root;
    }
}