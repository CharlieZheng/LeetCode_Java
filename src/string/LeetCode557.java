package string;

/**
 * @author hanrong on 2017/8/11.
 */
public class LeetCode557 {
    public static void main(String[] args) {
        LeetCode557 leetCode557 = new LeetCode557();
        System.out.println(leetCode557.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        String[] stringArray = s.split(" ");
        for (int i = 0; i < stringArray.length; i++) {
            String item = stringArray[i];
            char[] itemChar = item.toCharArray();
            for (int j = 0; j < itemChar.length / 2; j++) {
                char temp = itemChar[itemChar.length - 1 - j];
                itemChar[itemChar.length - 1 - j] = itemChar[j];
                itemChar[j] = temp;
            }
            stringArray[i] = String.copyValueOf(itemChar);
        }
        String result = "";
        for (int i = 0; i < stringArray.length; i++) {
            String item = stringArray[i];
            if (i == stringArray.length - 1) {
                result += item;
            } else {
                result += item + " ";
            }
        }
        return result;
    }
}
