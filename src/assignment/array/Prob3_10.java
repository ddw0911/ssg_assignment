package assignment.array;

import java.io.IOException;

public class Prob3_10 {
    public static void main(String[] args) throws IOException {
        int[][] a = SetArray.setMultiIntArray(3,4);
        int[][] b = SetArray.setMultiIntArray(3,4);
        int[][] c = new int[3][4];
        Prob3_10 prob310 = new Prob3_10();
        prob310.sub(a, b, c);
        prob310.prn(c);
    }

    public int[][] sub(int[][] a, int[][] b, int[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    public void prn(int[][] c) {
        for (int[] arr : c) {
            for (int result : arr) {
                System.out.print(result + " ");
            }
            System.out.println();
        }
    }
}
