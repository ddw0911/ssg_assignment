package assignment.board.jdbccrud;

import static assignment.board.CommonResource.boardList;
import static assignment.board.PrintMenu.confirmMenu;

import assignment.board.Board;

public class Delete {

  static void delete(Board board) {
    if (checkAgain()) {
      boardList.remove(board);
      System.out.println("게시물이 삭제되었습니다.\n");
    } else {
      System.out.println("취소되었습니다.");
    }
  }

  public static void clear() {
    if (checkNull()) {
      if (checkAgain()) {
        boardList.clear();
        System.out.println("게시물 목록이 초기화되었습니다.\n");
      } else {
        System.out.println("취소되었습니다.");
      }
    } else {
      System.out.println("이미 게시물이 존재하지 않습니다.\n");
    }
  }

  private static boolean checkAgain() {

      System.out.println("정말로 삭제하시겠습니까?");

      if (confirmMenu()) {
        return true;
      }
    return false;
  }

  private static boolean checkNull() {
    if (boardList.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }
}
