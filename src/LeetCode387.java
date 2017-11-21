import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LeetCode387 {
    public static void main(String[] args) {
        LeetCode387 leetCode387 = new LeetCode387();
        System.out.println(leetCode387.firstUniqChar("cc"));
    }

    private class Node {
        public Node(char name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }
        char name;
        int cnt;
    }

    public int firstUniqChar(String s) {
        Node[] cntArray = new Node[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean has = false;
            for (int j = 0; j < index; j++) {
                if (cntArray[j].name == s.charAt(i)) {
                    cntArray[j].cnt++;
                    has = true;
                    break;
                }
            }
            if (!has) {
                cntArray[index++] = new Node(s.charAt(i), 1);
            }
        }
        int rs = -1;
        for (int i = 0; i < cntArray.length; i++) {
            if (cntArray[i] != null && cntArray[i].cnt == 1) {
                rs = s.indexOf(cntArray[i].name);
                break;
            }
        }
        return rs;
    }
}
