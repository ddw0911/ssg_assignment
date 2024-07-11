package assignment.array;

import java.io.IOException;
import java.util.Arrays;

public class Prob3_13 {
    public static void main(String[] args) throws IOException {

        char[] s = SetArray.setCharArray();
        System.out.println(Arrays.toString(reverseString(s, 0, 10)));
    }

    static char[] reverseString(char[] s, int start, int end) {
        char temp;
        for (int i = 0; i < s.length; i++) {
            if (start > end) { //
                break;
            }
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

        return s;
    }
}
