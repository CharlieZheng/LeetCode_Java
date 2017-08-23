package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ACYetLeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
       result.add( Arrays.stream( nums ).boxed().collect(Collectors.toList()));
return null;
    }
}
