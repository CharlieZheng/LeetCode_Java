import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hanrong on 2017/5/24.
 */
public class LeetCode3 {
    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
//        List<Character> characterList = leetCode3.function(hh); // dvdf, aab, abcabcbb
//        for (Character item : characterList) {
//            System.out.print(item);
//        }
        int length = leetCode3.lengthOfLongestSubstring("abcabcbb");
        System.out.print(length);
    }

    public List<Character> function(String s) {
        boolean continueBoolean = false;
        List<Character> longest = new ArrayList<>();
        List<Character> cur = new ArrayList<>();
        int curIndex = 0;
        while (curIndex < s.length()) {
            for (int i = curIndex; i < s.length(); i++) {
                for (int j = 0; j < cur.size(); j++) {
                    if (s.charAt(i) == cur.get(j)) {
                        curIndex = curIndex + j + 1;
                        if (longest.size() < cur.size()) {
                            longest.clear();
                            longest.addAll(cur);
                        }
                        cur.clear();
                        continueBoolean = true;
                        break;
                    }
                }
                if (!continueBoolean) {
                    cur.add(s.charAt(i));
                } else {
                    continueBoolean = false;
                    break;
                }
            }
        }
        if (longest.size() < cur.size()) {
            longest.clear();
            longest.addAll(cur);
        }
        return longest;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
