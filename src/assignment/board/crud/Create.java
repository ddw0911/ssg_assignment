package assignment.board.crud;

import static assignment.board.CommonResource.boardList;
import static assignment.board.CommonResource.br;
import static assignment.board.PrintMenu.confirmMenu;

import assignment.board.Board;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class Create {

  public static void create() {
    Board board = new Board();
    System.out.println("[새 게시물 입력]");

    board.setTitle(inputRequired("제목"));
    board.setContent(inputRequired("내용"));
    board.setWriter(inputRequired("작성자"));

    System.out.println("----------------------------------------------------------------");

    if (confirmMenu()) {
      board.setNo(boardList.size() + 1);
      board.setDate(Date.valueOf(LocalDate.now()));
      System.out.println("입력되었습니다.");
      boardList.add(board);
    } else {
      System.out.println("입력이 취소되었습니다.");
    }
    System.out.println();
  }

  //입력필수항목 처리 메서드
  static String inputRequired(String subject) {
    String input;
    while (true) {
      try {
        System.out.print(subject + ": ");
        input = br.readLine();

        if (input.trim().isBlank()) {
          System.out.println("입력은 필수입니다.");
        } else {
          break;
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return input;
  }
}
