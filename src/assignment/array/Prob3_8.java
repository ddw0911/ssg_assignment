package assignment.array;


public class Prob3_8 {
    public static void main(String[] args) {
        int[][] count = new int[5][5];
        int k = 1;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i].length; j++) {
                count[i][j] = 5 * k - j;
                System.out.print(count[i][j]);
            }
            System.out.println();
            k++;
        }
    }
}
