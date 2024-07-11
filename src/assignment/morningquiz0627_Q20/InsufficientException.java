package assignment.morningquiz0627_Q20;

public class InsufficientException extends Exception{
  private static final int MAX_ACCOUNT = 100;

  public InsufficientException(String message) {
    super(message);
  }

  // 관리계좌 수를 넘기면 계좌생성불가
  static void overAccountException(int currentAccCount) throws InsufficientException {
    if (currentAccCount >= MAX_ACCOUNT) {
      throw new InsufficientException("더 이상 계좌를 생성할 수 없습니다.");
    }
  }

  // 동록되지 않은 계좌일 때
  static void isSignInAccount(String accNum) throws InsufficientException {
    int i = 0;
    while (i < BankApplication.accounts.length) {
      if (BankApplication.accounts[i] == null) {
        i++;
        break;
      }
      if (i == BankApplication.accounts.length - 1 && !(accNum.equals(BankApplication.accounts[i].accNum))) {
        throw new InsufficientException("없는 계좌번호입니다.");
      }
      i++;
    }
  }

  static void isAvailableWithdraw(int withdrawal, int balance) throws InsufficientException {
    if (withdrawal > balance) { // 잔액보다 출금액이 크면
      throw new InsufficientException("잔액이 부족합니다.");
    }
  }
}
