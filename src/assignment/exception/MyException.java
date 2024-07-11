package assignment.exception;

public class MyException extends Exception {

  public MyException(String message) {
    super(message);
  }

  public static void prob1Check(String s) throws MyException {
    if (s == null || s.isEmpty()) {
      throw new MyException("예외가 발생되었습니다. 문자열을 입력하지 않고 Enter키를 누르셨습니다..");
    }
  }

  public static void prob2CallEx(int time) throws MyException {
    if (time < 0) {
      throw new MyException("통화시간입력오류");
    }
  }

  public static void prob2ChargeEx(int time) throws MyException {
    if (time < 0) {
      throw new MyException("충전시간입력오류");
    }
  }
}
