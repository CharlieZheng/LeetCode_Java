import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hanrong on 2017/5/24.
 */
public class LeetCode506 {
    public static void main(String[] args) {
        LeetCode506 leetCode506 = new LeetCode506();
        String[] strArray = leetCode506.findRelativeRanks(new int[]{});
    }

    public String[] findRelativeRanks(int[] nums) {
        String[] rs = new String[nums.length];
        if (nums.length > 0) {
            rs[0] = "Gold Medal" ;
        }
        if (nums.length > 1) {
            rs[1] =  "Silver Medal";
        }
        if (nums.length > 2) {
            rs[2] = "Bronze Medal";
        }
        
        if (nums.length > 3) {
            for (int i = 4; i < nums.length + 1; i++) {
                rs[i] = "" + i;
            }
        }
        return rs;
    }
}
