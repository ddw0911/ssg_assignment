package assignment.array;

import java.io.IOException;

public class Prob3_11 {
    public static void main(String[] args) throws IOException {
        int[] a = SetArray.setIntArray();
        int[] b = SetArray.setIntArray();
        printEquals(a, b);
    }

    static boolean equalsArray(int[]a ,int[]b) {
        boolean result = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]){
                result = false;
            } else if (a[i] == b[i] && i == a.length - 1) {
                result = true;
            }
        }
        return result;
    }

    static void printEquals(int[]a, int[]b) {
        String s = equalsArray(a,b) ? "equals" : "not-equals";
        System.out.println("two array " + s);
    }
}
