package tree;

import dynamic_programming.LeetCode673;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LeetCode671 {
    public static void main(String[] args) {
        TreeNode child = new TreeNode(5);
        child.left = new TreeNode(5);
        child.right = new TreeNode(7);
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(2);
        treeNode.right = child;
        LeetCode671 leetCode671 = new LeetCode671();
        System.out.println(leetCode671.findSecondMinimumValue(treeNode));
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> integerList = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode item = stack.pop();
            integerList.add(item.val);
            if (item.left != null) stack.push(item.left);
            if (item.right != null) stack.push(item.right);
        }
        Collections.sort(integerList);
        int second = integerList.get(0);
        for (Integer item : integerList) {
            if (second != item) {
                second = item;
                break;
            }
        }
        return second;
    }
}
