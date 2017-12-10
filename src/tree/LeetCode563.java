package tree;

import java.util.Stack;

public class LeetCode563 {
    public static void main(String[] args) {
        LeetCode563 leetCode563 = new LeetCode563();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        System.out.println(leetCode563.findTilt(treeNode));
    }

    public int findTilt(TreeNode root) {
        Stack stack = new Stack();
        stack.push(root);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode cur = (TreeNode) stack.pop();
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left == null && cur.right == null) result = cur.val;
        }
        return result;
    }
}
