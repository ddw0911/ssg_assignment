package assignment.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob3_3 {
    public static void main(String[] args) throws IOException {
        printUniqueNumber(setArray());
    }

    // 배열 값을 입력받는 메서드
    private static int[] setArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[st.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
    public static void printUniqueNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j <= array.length; j++) {
                if (i != j - 1 && array[i] != array[j - 1]) {
                    if (j == array.length - 1) {
                        System.out.println(array[i]);
                    }
                } else {
                    break;
                }
            }
        }
    }
}
