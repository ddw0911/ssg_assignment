package assignment.array;

import java.io.IOException;

public class Prob3_7 {
    public static void main(String[] args) throws IOException {
        int[] arr = SetArray.setIntArray();
        Prob3_7 cal = new Prob3_7();
        cal.calculate(arr);
    }

    void calculate(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        for (int i : nums) {
            double result = Math.round((double) i / sum * 100);
            // Math.round 메서드를 이용하여 반올림처리
            for (int j = 0; j < (int) result; j++) {
                System.out.print("*");
            }
            System.out.println("(" + result +"%)");
        }
    }
}
