package leetcode;

public class LC104 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class Solution {

		int height = 0;

		public int maxDepth(TreeNode root) {
			recursiveFunc(root, 0);
			return height;
		}

		public void recursiveFunc(TreeNode node, int depth) {
			if (node == null) {
				height = Math.max(height, depth);
				return;
			}
			recursiveFunc(node.left, depth + 1);
			recursiveFunc(node.right, depth + 1);
		}
	}
}
