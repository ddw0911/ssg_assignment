package assignment.board;

import static assignment.board.Board.showList;
import static assignment.board.BoardExample.br;
import static assignment.board.jdbccrud.Create.create;
import static assignment.board.jdbccrud.Delete.clear;
import static assignment.board.jdbccrud.Read.read;

import java.io.IOException;

public class PrintMenu {

  public static void mainMenu() {
    while (true) {
      System.out.println("[게시물 목록]");
      System.out.println("----------------------------------------------------------------");
      System.out.println("no\t\twriter\t\t\t\tdate\t\t\t\t\t\t\t\ttitle");
      System.out.println("----------------------------------------------------------------");
      showList();
      System.out.println("메인 메뉴 : 1.Create | 2.Read | 3.Clear | 4.Exit");
      System.out.print("메뉴 선택 : ");

      try {
        int select = Integer.parseInt(br.readLine());
        System.out.println();

        switch (select) {
          case 1 -> create();
          case 2 -> read();
          case 3 -> clear();
          case 4 -> {
            System.out.println("**게시물 종료**");
            return;
          }
          default -> {System.out.println("오류: 올바른 메뉴번호를 입력하세요.\n");
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      } catch (NumberFormatException | NullPointerException e) {
        System.out.println("오류: 메뉴를 선택해주세요.\n");
      }
    }
  }

  public static boolean confirmMenu() {
    while (true) {
      System.out.println("보조 메뉴: 1.OK | 2.Cancel");
      System.out.print("메뉴 선택: ");
      try {
        int select = Integer.parseInt(br.readLine());
        if (select == 1) {
          return true;
        } else if (select == 2) {
          return false;
        } else {
          System.out.println("올바른 메뉴를 선택하세요.");
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      } catch (NumberFormatException | NullPointerException e) {
        System.out.println("오류: 메뉴를 선택해주세요.\n");
      }
    }
  }
}
