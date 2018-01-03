package binary_search;

public class _374 {
    private final int NUM = 6;

    private int guess(int num) {
        return Integer.compare(NUM, num);
    }

    private int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid = left + (right - left) / 2;
        while (right - left > 1) {
            int guessResult = guess(mid);
            if (guessResult == 0) return mid;
            else if (guessResult < 0) {
                right = mid;
            } else {
                left = mid;
            }
            mid = left + (right - left) / 2;
        }
        if (guess(left) == 0) return left;
        if (guess(right) == 0) return right;
        return 0;
    }

    public static void main(String[] args) {
        _374 o = new _374();
        for (int i = 0; i < 10; i++)
            System.out.println(o.guessNumber(i));
    }
}
