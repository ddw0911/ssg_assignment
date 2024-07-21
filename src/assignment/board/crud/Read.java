package assignment.board.crud;

import static assignment.board.PrintMenu.mainMenu;
import static assignment.board.CommonResource.boardList;
import static assignment.board.CommonResource.br;
import static assignment.board.crud.Delete.delete;
import static assignment.board.crud.Update.update;

import assignment.board.Board;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Read {
  public static void read() {
    System.out.println("[게시물 읽기]");
    System.out.print("no: ");
    try {
      int boardNum = Integer.parseInt(br.readLine());
      findBoard(boardNum, boardList);
      System.out.println();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // 번호에 맞는 게시물 찾기
  static void findBoard(int no, List<Board> boardList) {
    Optional<Board> result = boardList.stream().filter(board -> board.getNo() == no).findAny();
    if (result.isPresent()) {
      System.out.println("#############");
      result.get().getBoardInfo();
      System.out.println("#############");
      nextMenu(result.get());
    } else {
      System.out.println("해당 게시물은 존재하지 않습니다.");
    }
  }

  static void nextMenu(Board board) {
    System.out.println("보조 메뉴: 1. Update | 2. Delete | 3. List");
    System.out.print("메뉴 선택: ");
    try {
      int select = Integer.parseInt(br.readLine());
      switch (select) {
        case 1 -> update(board);
        case 2 -> delete(board);
        case 3 -> mainMenu();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
