package assignment.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SetArray {

    static int[] setIntArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[st.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    static int[][] setMultiIntArray(int cols, int rows) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[cols][rows];

        for (int i = 0; i < cols; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < rows; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return arr;
    }

    static char[] setCharArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char[] arr = new char[input.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.charAt(i);
        }
        return arr;
    }
}

