package assignment.array;

public class Prob2_2 {
    public static void main(String[] args) {
        char[][] alpha = new char[5][5];
        char init = 'A';
        // 원본
//
//        for (int i = 0; i < alpha.length; i++) {
//            for (int j = 0; j < alpha[i].length; j++) {
//                alpha[i][j] = (char) (init + j);
//                System.out.print(alpha[i][j] + "\t\t");
//            }
//            init = (char) (alpha[i][alpha.length-1] + 1);
//            System.out.println();
//        }

        // 수정
        for (int i = 0; i < alpha.length; i++) {
            for (int j = 0; j < alpha[i].length; j++) {
                if (i == j) {
                    alpha[i][j] = '*';
                } else {
                    alpha[i][j] = (char) (init + j);
                }
                System.out.print(alpha[i][j] + "\t\t");
            }
            init = (char) (alpha[i][alpha.length-1] + 1);
            System.out.println();
        }
    }
}
