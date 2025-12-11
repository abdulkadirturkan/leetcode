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
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIndexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd, int inStart, int inEnd){
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = inorderIndexMap.get(rootVal);
        int leftTreeSize = inRootIndex - inStart;

        root.left = build(postorder, postStart, postStart + leftTreeSize - 1, inStart, inRootIndex - 1);
        root.right = build(postorder, postStart + leftTreeSize, postEnd - 1, inRootIndex + 1, inEnd);

        return root;

    }
}
