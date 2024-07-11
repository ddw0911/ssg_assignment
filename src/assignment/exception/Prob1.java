package assignment.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int result = 0;

  public static void main(String[] args) throws IOException {
    //필요할 경우 다음의 메서드 선언부분(메서드 시그너처)을 수정하시기 바랍니다.


    System.out.println("숫자로 변환할 문자열을 입력바랍니다.");
      String str = br.readLine();
      //여기를 작성하십시오.
    convert(str);
    }

    //필요할 경우 다음의 메서드 선언부분(메서드 시그너처)을 수정하시기 바랍니다.
    private static int convert(String str) throws IOException {
      //여기를 작성하십시오.

      try {
        MyException.prob1Check(str);
        System.out.println(Integer.parseInt(str));
      } catch (MyException e) {
        System.out.println(e.getMessage());
      } finally {
        br.close();
        System.out.println("프로그램 종료");
      }
      return result;
    }
  }
