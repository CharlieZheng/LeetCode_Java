package tree;

public class LeetCode404 {
    public static void main(String[] args) {
        LeetCode404 leetCode404 = new LeetCode404();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(leetCode404.sumOfLeftLeaves(treeNode));
    }

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null && root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        if (root != null)
            sumOfLeftLeaves(root.left);
        if (root != null)
            sumOfLeftLeaves(root.right);
        return sum;
    }
}
