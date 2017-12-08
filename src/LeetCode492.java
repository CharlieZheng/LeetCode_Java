public class LeetCode492 {
    public static void main(String[] args) {
        LeetCode492 leetCode492 = new LeetCode492();
        int[] result = leetCode492.constructRectangle(3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] constructRectangle(int area) {
        if (area == 0) return new int[]{};
        int[] result = new int[2];
        int a = 1;
        int cha = Integer.MAX_VALUE;
        int b = 0;
        while (area / a >= a) {
            if (area % a == 0) {
                if (cha > area / a - a) {
                    cha = area / a - a;
                    b = a;
                }
            }
            a++;
        }
        result[0] = area / b;
        result[1] = b;
        return result;
    }
}
