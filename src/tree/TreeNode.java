package tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(Integer[] a) {
        if (a == null) return;
        val = a[0];
        TreeNode curNode = this;
        for (int i = 1; i < a.length - 1 && curNode != null; i=i+2) {
            if (a[i] != null){ curNode.left = new TreeNode(a[i]); curNode = curNode.left;continue;}
            if (a[i + 1] != null) curNode.right = new TreeNode(a[i + 1]);
            if (curNode.left != null){ curNode = curNode.left;}else
            if (curNode.right != null) curNode = curNode.right;else curNode =null;
        }
    }

    @Override
    public String toString() {
        return val +
                ", " + (left != null ? left.toString() : "null") +
                ", " + (right != null ? right.toString() : "null");
    }
}
