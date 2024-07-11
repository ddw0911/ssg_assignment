package assignment.array;

import java.io.IOException;
import java.util.Arrays;

public class Prob3_12 {
    public static void main(String[] args) throws IOException {
        int[] a = SetArray.setIntArray();

        System.out.println(Arrays.toString(ascending(a)));
    }

    static int[] ascending(int[] inputNumbers) {
        int temp;
        for (int i = 0; i < inputNumbers.length; i++) {
            for (int j = i+1; j < inputNumbers.length; j++) {
                if (inputNumbers[i] > inputNumbers[j]) {
                    temp = inputNumbers[j];
                    inputNumbers[j] = inputNumbers[i];
                    inputNumbers[i] = temp;
                }
            }
        }
        return inputNumbers;
    }
}
