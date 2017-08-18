package com.jy;

public class Main {

	public static void main(String[] args) {
		// 构建树A
		TreeNode treeANode1 = new TreeNode(4, null, null);
		TreeNode treeANode2 = new TreeNode(7, null, null);
		TreeNode treeANode3 = new TreeNode(2, treeANode1, treeANode2);
		TreeNode treeANode4 = new TreeNode(9, null, null);
		TreeNode treeANode5 = new TreeNode(8, treeANode4, treeANode3);
		TreeNode treeANode6 = new TreeNode(7, null, null);
		TreeNode rootA = new TreeNode(8, treeANode5, treeANode6);

		// 构建树B
		TreeNode treeBNode1 = new TreeNode(9, null, null);
		TreeNode treeBNode2 = new TreeNode(2, null, null);
		TreeNode rootB = new TreeNode(8, treeBNode1, treeBNode2);

		System.out.print("先序遍树A：");
		preOrder(rootA);

		System.out.println();

		System.out.print("先序遍树B：");
		preOrder(rootB);

		System.out.println();

		System.out.println("树A中是否包含树B：" + HasSubTree(rootA, rootB));
	}

	/**
	 * 在A树中查找，是否包含树B
	 * 
	 * @param rootA
	 *            被查找的母树
	 * @param rootB
	 *            用来查找的子树
	 * @return 包含返回true，否则返回false
	 */
	public static boolean HasSubTree(TreeNode rootA, TreeNode rootB) {
		boolean result = false;
		if (rootA != null && rootB != null) { // 鲁棒性检查
			if (rootA.mValue == rootB.mValue) // 先找到相等的某一个非叶子节点
				// 再以为子节点为根节点往下比较树A是否包含树B
				result = match(rootA, rootB);
			// 如果当前节点不满足，则继续递归从它的左右子节点开始往下比较
			if (!result)
				result = HasSubTree(rootA.mLeft, rootB);
			if (!result)
				result = HasSubTree(rootA.mRight, rootB);
		}
		return result;
	}

	/**
	 * 当根节点的值相同时，继续往下比较树A中是否包含树B
	 * 
	 * @param rootA
	 *            被查找的母树
	 * @param rootB
	 *            用来查找的子树
	 * @return 包含返回true，否则返回false
	 */
	public static boolean match(TreeNode rootA, TreeNode rootB) {
		// 到达树B、或树A的叶子节点
		if (rootB == null)
			return true;
		if (rootA == null)
			return false;
		if (rootA.mValue != rootB.mValue)
			return false;
		return match(rootA.mLeft, rootB.mLeft) && match(rootA.mRight, rootB.mRight);
	}

	/**
	 * 先序遍历二叉树并输出
	 * 
	 * @param root
	 *            待遍历的二叉树的根节点
	 */
	public static void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.mValue + " ");
			if (root.mLeft != null)
				preOrder(root.mLeft);
			if (root.mRight != null)
				preOrder(root.mRight);
		}
	}
}
