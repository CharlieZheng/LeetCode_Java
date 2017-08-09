package tree;

public class LeetCode617 {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.left.left = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.right = new TreeNode(2);
        treeNode2.right.right = new TreeNode(3);
        LeetCode617 leetCode617 = new LeetCode617();
        TreeNode treeNode = leetCode617.mergeTrees(treeNode1, treeNode2);
        System.out.println(treeNode);
    }



    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        TreeNode t;
        if (t1 == null) {
            t = new TreeNode(t2.val);
            t.left = mergeTrees(null, t2.left);
            t.right = mergeTrees(null, t2.right);
        } else if (t2 == null) {
            t = new TreeNode(t1.val);
            t.left = mergeTrees(t1.left, null);
            t.right = mergeTrees(t1.right, null);
        } else {
            t = new TreeNode(t1.val + t2.val);
            t.left = mergeTrees(t1.left, t2.left);
            t.right = mergeTrees(t1.right, t2.right);
        }
        return t;
    }
}
