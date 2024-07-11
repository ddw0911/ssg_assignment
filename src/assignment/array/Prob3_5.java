package assignment.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob3_5 {
    public static void main(String[] args) throws IOException {
        int[] value = setArray();
        System.out.println(getValue(value, true));
        System.out.println(getValue(value, false));
    }

    private static int getValue(int[] values, boolean isMax) {
        int max = values[0];
        int min = values[0];

        for (int value : values) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        return isMax ? max : min;
    }

    private static int[] setArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[st.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}
