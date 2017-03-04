package _2017_03_02;

public class MinimumAbsoluteDifferenceinBST {
	int min = Integer.MAX_VALUE;
	int previous = Integer.MAX_VALUE;
	public int getMinimumDifference(TreeNode root) {
		if(root == null) return 0;
		getMinimumDifference(root.left);
		int diff = Math.abs(root.val - previous);
		previous = root.val;
		min = Math.min(min, diff);
		getMinimumDifference(root.right);
		return min;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
