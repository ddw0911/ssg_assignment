package assignment.morningquiz0627_Q20;

import java.util.Scanner;

class BankApplication extends Account {

  Scanner sc = new Scanner(System.in);

  final static Account[] accounts = new Account[100]; // 관리 계좌는 총 100개
  int currentAccCount = 0; // 현재 계좌 수

  public BankApplication() {

  }

  void startBankApplication() { // 앱 시작
    showOption(); // 선택 옵션 표시
  }

  void showOption() {
    while (true) {
      System.out.println("--------------------------------------");
      System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
      System.out.println("--------------------------------------");
      System.out.print("선택> ");
      int i = sc.nextInt();
      sc.nextLine(); // 옵션 선택
      switch (i) {
        case 1 -> openAccount();
        case 2 -> listAccount();
        case 3 -> depositResult();
        case 4 -> withdrawalResult();
        case 5 -> {exit();
        return;}
        default -> System.out.println("올바른 옵션을 선택하세요");
      }
    }
  }


  void openAccount() { // 계좌생성

    try {
      InsufficientException.overAccountException(currentAccCount);
      System.out.println("----------------");
      System.out.println("계좌생성");
      System.out.println("----------------");

      System.out.print("계좌번호: ");
      accNum = sc.nextLine();

      System.out.print("계좌주: ");
      accOwner = sc.nextLine();

      System.out.print("초기입금액: ");
      balance = sc.nextInt();
      sc.nextLine();

      accounts[currentAccCount] = new Account(accNum, accOwner, balance); // 입력받은 값을 관리계좌로 등록
      currentAccCount++;

      System.out.println("결과: 계좌가 생성되었습니다.");
    } catch (InsufficientException e) {
      System.out.println(e.getMessage());
    }
  }

  void listAccount() { // 계좌목록
    System.out.println("----------------");
    System.out.println("계좌목록");
    System.out.println("----------------");
    for (int i = 0; i < currentAccCount; i++) { // 현재까지 등록된 계좌와 정보 표시
      System.out.println(accounts[i].accNum + "\t\t" + accounts[i].accOwner + "\t\t" + accounts[i].balance);
    }
  }

  void depositResult() { // 예금
    System.out.println("----------------");
    System.out.println("예금");
    System.out.println("----------------");
    System.out.print("계좌번호: ");
    accNum = sc.nextLine();

    try {
      InsufficientException.isSignInAccount(accNum);
      int i = 0;
      while (i < accounts.length) {
        if (accNum.equals(BankApplication.accounts[i].accNum)) {
          System.out.print("예금액: ");
          accounts[i].balance += sc.nextInt(); // 해당 계좌에 입금
          sc.nextLine();
          System.out.println("잔액: " + accounts[i].balance);
          break;
        }
        i++;
      }
    } catch (InsufficientException e) {
      System.out.println(e.getMessage());
    } catch (NullPointerException e) {
      System.out.println("없는 계좌입니다.");
    }
  }

  void withdrawalResult() {
    System.out.println("----------------");
    System.out.println("출금");
    System.out.println("----------------");
    System.out.print("계좌번호: ");
    accNum = sc.nextLine();

    try {
      InsufficientException.isSignInAccount(accNum);
      int i = 0;
      while (i < accounts.length) {
        if (accNum.equals(BankApplication.accounts[i].accNum)) {
          System.out.print("출금액: ");
          int withdrawalAmount = sc.nextInt();
          sc.nextLine();

          try {
            InsufficientException.isAvailableWithdraw(withdrawalAmount, this.balance);
            accounts[i].balance -= withdrawalAmount; // 해당 계좌에서 출금
            System.out.println("결과: 출금이 성공되었습니다.");
            System.out.println("잔액: " + accounts[i].balance);
            break;
          } catch (InsufficientException e) {
            System.out.println(e.getMessage());
          }
        }
        i++;
      }
    } catch (InsufficientException e) {
      System.out.println(e.getMessage());
    } catch (NullPointerException e) {
    }
  }

  void exit() {
    System.out.print("프로그램 종료");
  }
}
