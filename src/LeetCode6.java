/**
 * @author hanrong on 2017/5/24.
 */
public class LeetCode6 {
    public static void main(String[] args) {
        LeetCode6 leetCode6 = new LeetCode6();
        System.out.println(leetCode6.convert("AB", 2));
    }

    public String convert(String s, int numRows) {
        int BASE_ARRAY_SIZE = 10;
        char[][] rowCharArray = new char[numRows][BASE_ARRAY_SIZE];
        int[] colIndexArray = new int[numRows];
        int rowIndexArrayLength;
        if (numRows == 0 || numRows == 1) {
            rowIndexArrayLength = 1;
        } else {
            rowIndexArrayLength = (numRows - 1) * 2;
        }
        int[] rowIndexArray = new int[rowIndexArrayLength];
        int peak = 1;
        int partRight = 1;
        for (int i = 0; i < rowIndexArrayLength; i++) {
            if (i <= rowIndexArrayLength / 2) {
                peak = 0;
                rowIndexArray[i] = i;
                if (i == rowIndexArrayLength / 2) {
                    peak = i;
                }
            } else {
                rowIndexArray[i] = peak - (partRight++);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            int rowIndex = rowIndexArray[i % rowIndexArrayLength];
            int colIndex = colIndexArray[rowIndex];
            if (colIndex >= rowCharArray[rowIndex].length) {
                char[] temp = rowCharArray[rowIndex];
                rowCharArray[rowIndex] = new char[rowCharArray[rowIndex].length + BASE_ARRAY_SIZE];
                System.arraycopy(temp, 0, rowCharArray[rowIndex], 0, temp.length);
            }
            rowCharArray[rowIndex][colIndex] = item;
            colIndexArray[rowIndex]++;
        }
        String result = "";
        for (int i = 0; i < numRows; i++) {
            result += new String(rowCharArray[i]).trim();
        }
        return result.trim();
    }
}