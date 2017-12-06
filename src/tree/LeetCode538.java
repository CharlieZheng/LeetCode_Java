package tree;

import java.util.Stack;

public class LeetCode538 {
    public static void main(String[] args) {
        LeetCode538 leetCode538 = new LeetCode538();
        TreeNode treeNodeLeft = new TreeNode(3);
        treeNodeLeft.left = new TreeNode(1);
        treeNodeLeft.right = new TreeNode(2);
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = treeNodeLeft;
        treeNode.right.right = new TreeNode(7);
        System.out.println(treeNode);
        leetCode538.mrl(treeNode);
//       leetCode538.mlr(treeNode);
    }

    //    public TreeNode convertBST(TreeNode root) {}
    public void mlr(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.println(treeNode.val);
            if (treeNode.left == null && treeNode.right == null) continue;
            if (treeNode.right != null) stack.push(treeNode.right);
            if (treeNode.left != null) stack.push(treeNode.left);
        }
    }

    public void mrl(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode treeNode = root;
        while (!stack.isEmpty() || treeNode != null) {

            if (treeNode != null) {
                System.out.println(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.right;
            } else {
                treeNode = stack.pop();
                treeNode = treeNode.left;
            }

        }
    }
}
