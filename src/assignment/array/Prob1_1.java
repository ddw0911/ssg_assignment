package assignment.array;

public class Prob1_1 {
    public static void main(String[] args) {
        int[] ia = new int[]{3,7,1,8,10,2,15,2,10};
        int[] ib = new int[]{1,2,3,4,5};

        oddEvenSum("ia",ia);
        oddEvenSum("ib",ib);
    }

    static void oddEvenSum(String name, int[] arr) {
        int oddSum = 0;
        int evenSum = 0;

        for (int i : arr) {
            if (i % 2 == 1) {
                oddSum += i;
            } else {
                evenSum += i;
            }
        }

        System.out.println("( 배열 " + name + " )");
        System.out.println("홀수의 합 : " + oddSum);
        System.out.println("짝수의 합 : " + evenSum);
    }
}
