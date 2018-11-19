/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null || R < L) {
			return 0;
		}
		LinkedList<TreeNode> values = new LinkedList<>();
		values.add(root);
		int sum = 0;
    //Shouldn't have a go through the entire tree. BFS
		while (!values.isEmpty()) {
			TreeNode node = values.remove();
			if (node.left != null)
				values.push(node.left);
			if (node.right != null)
				values.push(node.right);
			if (node != null && node.val >= L && node.val <= R) {
				sum+= node.val;
			}
		}
		return sum;
    }
}
