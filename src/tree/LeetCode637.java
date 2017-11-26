package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode637 {
    public static void main(String[] args) {
        LeetCode637 leetCode637 = new LeetCode637();
        TreeNode child = new TreeNode(20);
        child.left = new TreeNode(15);
        child.right = new TreeNode(7);
        TreeNode treeNode = new TreeNode(2147483647);
        treeNode.left = new TreeNode(2147483647);
        treeNode.right = new TreeNode(2147483647);
        List<Double> doubleList = leetCode637.averageOfLevels(treeNode);
        for (int i = 0; i < doubleList.size(); i++) {
            System.out.print(doubleList.get(i) + "\t");
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<List<TreeNode>> stack = new Stack<>();
        List<TreeNode> treeNodeList1 = new ArrayList<>();
        List<TreeNode> treeNodeList2;
        treeNodeList1.add(root);
        stack.push(treeNodeList1);
        List<Double> sumList = new ArrayList<>();
        while (!stack.isEmpty()) {
            treeNodeList1 = stack.pop();
            treeNodeList2 = new ArrayList<>();
            double average = 0;
            for (TreeNode item : treeNodeList1) {
                average += item.val;
                if (item.left != null) treeNodeList2.add(item.left);
                if (item.right != null) treeNodeList2.add(item.right);
            }
            sumList.add(average / treeNodeList1.size());
            if (treeNodeList2.size() > 0) stack.push(treeNodeList2);
        }
        return sumList;
    }
}
