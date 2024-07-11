package assignment.array;

import java.io.IOException;
import java.util.Arrays;

public class Prob3_6 {
    public static void main(String[] args) throws IOException {
        int[] arr = SetArray.setIntArray(); // SetArray 클래스의 입력값으로 배열만들기 메서드
        System.out.println("input: " + Arrays.toString(arr));
        System.out.println("median: " + findMedian(arr));
    }

    // 평균값에 가장 가까운 값을 계산
    private static int findMedian(int[] values) {
        int sum = 0;

        for (int value : values) {
            sum += value;
        }
        int avg = sum / values.length;

        int median = 0;
        int minAbs = Math.abs(avg - values[0]); // 최소절대값 변수 선언 및 초기화
        for (int value : values) {
            int currentAbs = Math.abs(avg - value);
            if (currentAbs < minAbs) { // 절대값 비교
                minAbs = currentAbs; // 더 작은 절대값을 최소 절대값으로 저장
                median = value; // 해당 절대값일 때 value를 median값으로 저장
            }
        }
        return median;
    }
}