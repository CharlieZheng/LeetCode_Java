package tree;

public class LeetCode563 {
    public static void main(String[] args) {
        LeetCode563 leetCode563 = new LeetCode563();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        System.out.println(leetCode563.findTilt(treeNode));
    }

    public int findTilt(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }

        if (root.left == null) {
            return findTilt(root.right);
        }

        if (root.right == null) {
            return findTilt(root.left);
        }
        return findTilt(root.left) + findTilt(root.right);

    }
}
