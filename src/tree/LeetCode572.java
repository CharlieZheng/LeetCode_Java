package tree;

public class LeetCode572 {
    public static void main(String[] args) {
        LeetCode572 leetCode572 = new LeetCode572();
        TreeNode treeNode1 = new TreeNode(new Integer[]{1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, 2});
        TreeNode treeNode2 = new TreeNode(new Integer[]{1, null, 1, null, 1, null, 1, null, 1, null, 1, 2});

        System.out.println(treeNode1.toString());
        System.out.println(treeNode2.toString());
        System.out.println(leetCode572.isSubtree(treeNode1, treeNode2));
    }

    private boolean same(TreeNode s, TreeNode t) {
        if (s == null) {
            if (t == null) return true;
            else return false;
        } else {
            if (t == null) return false;
            else return same(s.left, t.left) && same(s.right, t.right) && s.val == t.val;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {

        return isSubtree(s.left, t) || isSubtree(s.right, t) || same(s.left, t) || same(s.right, t) || same(s, t);
    }
}
