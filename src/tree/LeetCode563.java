package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode563 {
    public static void main(String[] args) {
        LeetCode563 leetCode563 = new LeetCode563();
        TreeNode childRight2Right = new TreeNode(7);
        childRight2Right.left = new TreeNode(17);
        childRight2Right.right = new TreeNode(71);
        TreeNode childRight = new TreeNode(3);
        childRight.left = new TreeNode(6);
        childRight.right = childRight2Right;
        TreeNode child2Left = new TreeNode(4);
        child2Left.left = new TreeNode(8);
        child2Left.right = new TreeNode(9);
        TreeNode child2Right = new TreeNode(5);
        child2Right.left = new TreeNode(10);
        TreeNode childLeft = new TreeNode(2);
        childLeft.left = child2Left;
        childLeft.right = child2Right;
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = childLeft;
        treeNode.right = childRight;
        System.out.println(leetCode563.findTilt(treeNode));
        leetCode563.printTreeLayer(treeNode);
    }

    public void printTreeLayer(TreeNode root) {
        List<List<TreeNode>> list = new ArrayList<>();
        List<TreeNode> curItem = new ArrayList<>();
        curItem.add(root);
        list.add(curItem);
        int lastIndex = 0;
        while (lastIndex < list.size() && list.get(lastIndex).size() > 0) {
            List<TreeNode> lastItem = list.get(lastIndex);
            curItem = new ArrayList<>();
            for (TreeNode item : lastItem) {
                if (item.left != null) curItem.add(item.left);
                if (item.right != null) curItem.add(item.right);
            }
            list.add(curItem);
            lastIndex++;
        }

        for (List<TreeNode> item1 : list) {
            for (TreeNode item2 : item1) {
                System.out.print(item2.val + "\t");
            }
            System.out.println();
        }
    }

    private void treeSum(TreeNode root) {
        if (root == null) return;
        List<List<TreeNode>> list = new ArrayList<>();
        List<TreeNode> curItem = new ArrayList<>();
        curItem.add(root);
        list.add(curItem);
        int lastIndex = 0;
        while (lastIndex < list.size() && list.get(lastIndex).size() > 0) {
            List<TreeNode> lastItem = list.get(lastIndex);
            curItem = new ArrayList<>();
            for (TreeNode item : lastItem) {
                if (item.left != null) curItem.add(item.left);
                if (item.right != null) curItem.add(item.right);
            }
            list.add(curItem);
            lastIndex++;
        }
        int curLeft = 0, curRight = 0;
        for (int i = list.size() - 2; i >= 0; i--) {
            List<TreeNode> item1 = list.get(i);
            for (TreeNode item2 : item1) {
                curLeft = 0;
                curRight = 0;
                if (item2.left != null) curLeft = item2.left.val;
                if (item2.right != null) curRight = item2.right.val;
                item2.val += curLeft + curRight;
            }
        }
    }

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        treeSum(root);
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode item = queue.poll();
            int left = 0;
            int right = 0;
            if (item.left != null) left = item.left.val;
            if (item.right != null) right = item.right.val;

            result += Math.abs(left - right);
            if (item.left != null) queue.add(item.left);
            if (item.right != null) queue.add(item.right);
        }
        return result;
    }
}
