package hash_table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode599 {
    public static void main(String[] args) {
        LeetCode599 leetCode599 = new LeetCode599();
        String[] strings = leetCode599.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"});
        for (String item : strings) {
            System.out.println(item);
        }
    }

    private class Node {
        public Node(String name, int indexSum) {
            this.name = name;
            this.indexSum = indexSum;
        }

        private String name;
        private int indexSum;
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        int length1 = list1.length;
        int length2 = list2.length;
        Node[] nodes = new Node[length1 > length2 ? length1 : length2];
        int index = 0;
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (list1[i].equals(list2[j])) {
                    nodes[index++] = new Node(list1[i], i + j);
                    break;
                }
            }
        }
        List<String> rs = new ArrayList<String>();
        int leastIndex = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null && leastIndex >= nodes[i].indexSum) {
                if (leastIndex > nodes[i].indexSum) {
                    rs.clear();
                    rs.add(nodes[i].name);
                    leastIndex = nodes[i].indexSum;
                } else if (leastIndex == nodes[i].indexSum) {
                    rs.add(nodes[i].name);
                    leastIndex = nodes[i].indexSum;
                }
            }
        }
        return rs.toArray(new String[rs.size()]);
    }
}
