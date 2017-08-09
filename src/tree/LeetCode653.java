package tree;

public class LeetCode653 {
    public static void main(String[] args) {
        LeetCode653 leetCode653 = new LeetCode653();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(7);
        System.out.println(leetCode653.findTarget(treeNode, 10) + "");
    }



    private TreeNode parentRoot;
    private int i = 0;

    public boolean findTarget(TreeNode root, int k) {
        if (i++ == 0) {
            parentRoot = root;
        }
        if (root == null) {
            return false;
        }
        int value = k - root.val;
        root.val = Integer.MIN_VALUE;
        boolean b = findVal(parentRoot, value);
        if (b) {
            return true;
        } else if (findTarget(root.left, k)) {
            return true;
        } else {
            return findTarget(root.right, k);
        }

    }

    private boolean findVal(TreeNode treeNode, int val) {
        if (val == treeNode.val) {
            return true;
        }

        if (treeNode.left != null) {
            if (findVal(treeNode.left, val)) {
                return true;
            }
        }
        if (treeNode.right != null) {
            if (findVal(treeNode.right, val)) {
                return true;
            }
        }
        return false;
    }
}
