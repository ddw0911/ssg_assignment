package assignment.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 10 30 20 80 50
        int[] num = new int[st.countTokens()];
        int sum = 0;

        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sum += num[i];
        }

        for (int i : num) {
            double result = (double) i / sum * 100;
            for (int j = 0; j < (int) result; j++) {
                System.out.print("*");
            }
            System.out.println("<" + result + "%>");
        }
    }
}
