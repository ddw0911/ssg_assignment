package assignment.array;

public class Prob1_2 {
    public static void main(String[] args) {
        int[] randomNum= new int[5];

        for (int i = 0; i < randomNum.length; i++) {
            randomNum[i] = (int) (Math.random() * 100) + 1;
            System.out.print(randomNum[i]);
            if (i == randomNum.length -1) {
                break;
            }
            System.out.print(" ");
        }
    }
}
