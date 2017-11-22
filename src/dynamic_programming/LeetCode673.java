package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class LeetCode673 {
    public static void main(String[] args) {
        LeetCode673 leetCode673 = new LeetCode673();
        System.out.println(leetCode673.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }

    private class Node {
        public Node(int name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }

        private int name;
        private int cnt;
    }

    public int findNumberOfLIS(int[] nums) {
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(new Node(nums[0], 1));
        for (int i = 1; i < nums.length; i++) {
            boolean found = false;
            for (int j = nodeList.size() - 1; j >= 0; j--) {
                if (nodeList.get(j).name < nums[i]) {
                    found = true;
                    nodeList.add(new Node(nums[i], nodeList.get(j).cnt + 1));
                    break;
                }
            }
            if (!found) {
                nodeList.add(new Node(nums[i], 1));
            }
        }
        int sum = 1;
        int maxCnt = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            if (maxCnt == nodeList.get(i).cnt) {
                sum++;
                continue;
            }
            if (maxCnt < nodeList.get(i).cnt) {
                maxCnt = nodeList.get(i).cnt;
                sum = 1;
            }
        }
        return sum;
    }
}
