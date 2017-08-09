package tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "{" +
                "\"val\":" + val +
                ",\"left\":" + ((left != null) ? left.toString() : "null") +
                ", \"right\":" + ((right != null) ? right.toString() : "null") +
                '}';
    }
}
