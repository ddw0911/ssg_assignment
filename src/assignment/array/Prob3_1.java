package assignment.array;

public class Prob3_1 {
    public static void main(String[] args) {

        int[] ia = new int[]{3,7,1,8,10,2,15,2,10};
        int[] ib = new int[]{1,2,3,4,5};

        Prob3_1 p = new Prob3_1();
        System.out.println("( 배열 ia )");
        p.calc(ia);
        System.out.println("( 배열ib )");
        p.calc(ib);

        //Prob1_1의 메서드
        Prob1_1.oddEvenSum("ia",ia);
        Prob1_1.oddEvenSum("ib",ib);
    }

    public void calc(int[] ix){
        int oddSum = 0;
        int evenSum = 0;

        for (int i : ix) {
            if (i % 2 == 1) {
                oddSum += i;
            } else {
                evenSum += i;
            }
        }
        System.out.println("홀수의 합 : " + oddSum);
        System.out.println("짝수의 합 : " + evenSum);
    }
}
