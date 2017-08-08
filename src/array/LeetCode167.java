package array;

public class LeetCode167 {
    public static void main(String[] args) {
        LeetCode167 leetCode167 = new LeetCode167();
        int[] numbers = new int[]{2, 7, 11, 15};
        numbers = leetCode167.twoSum(numbers, 9);
        for (int i : numbers) {
            System.out.println(i + "");
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = in(numbers, i, target - numbers[i]);
            if (j != -1) {
                if (i < j) {
                    return new int[]{i + 1, j + 1};
                } else {
                    return new int[]{j + 1, i + 1};
                }
            }
        }
        return new int[]{};
    }

    private int in(int[] numbers, int index, int num) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num && index != i) {
                return i;
            }
        }
        return -1;
    }
}
