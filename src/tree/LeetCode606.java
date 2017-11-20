package tree;

public class LeetCode606 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(3);
        LeetCode606 leetCode606 = new LeetCode606();
        System.out.println(leetCode606.tree2str(treeNode));
    }

    public String tree2str(TreeNode t) {
        String temp = "";
        if (t == null) {
            return temp;
        }
        if (t.left != null) {
            if (t.right != null) {

                temp = t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
            } else {
                temp = t.val + "(" + tree2str(t.left) + ")";
            }
        } else {
            if (t.right != null) {
                temp = t.val + "()" + "(" + tree2str(t.right) + ")";
            } else {
                temp = t.val + "";
            }
        }
        return temp;
    }
}
