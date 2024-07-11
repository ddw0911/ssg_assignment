package assignment.array;

public class Prob3_2 {
    public static void main(String[] args) {
        int[] random = new int[10];
        generateRandom(random);
        getMaxNum(random);
    }

    private static void generateRandom(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 30) + 1;
            System.out.print(arr[i] + ",");
        }
    }

    private static void getMaxNum(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        System.out.println("배열에서 가장 큰 숫자 : " + max);
    }
}
