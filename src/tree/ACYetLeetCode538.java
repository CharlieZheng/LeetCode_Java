package tree;

public class ACYetLeetCode538 {
    public static void main(String[] args) {
        ACYetLeetCode538 acYetLeetCode538 = new ACYetLeetCode538();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(7);
        System.out.println(acYetLeetCode538.convertBST(treeNode));
    }

    public TreeNode convertBST(TreeNode root) {
        if ((root.left != null && root.left.left == null && root.left.right == null) || (root.right.left == null && root.right.right == null)) {
            if (root.right != null) root.val += root.right.val;
            if (root.left != null) root.left.val += root.val;
        } else {
            root.val += root.right.val;
            root.left.val += root.val;
            convertBST(root.right);
        }

        return root;
    }
}
