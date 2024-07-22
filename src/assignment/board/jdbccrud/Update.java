package assignment.board.jdbccrud;

import static assignment.board.PrintMenu.confirmMenu;
import static assignment.board.jdbccrud.Create.inputRequired;

import assignment.board.Board;

public class Update {

  static void update(Board board) {
    String title;
    String content;
    String writer;
    title = inputRequired("제목");
    content = inputRequired("내용");
    writer = inputRequired("작성자");

    if (confirmMenu()) {
      board.setTitle(title);
      board.setContent(content);
      board.setWriter(writer);
      System.out.println("수정이 완료되었습니다.\n");
    } else {
      System.out.println("수정이 취소되었습니다.\n");
    }
  }
}
