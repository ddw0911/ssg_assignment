package assignment.board;

import static assignment.board.dto.MainMenu.mainMenu;
import static assignment.board.util.UtilMethod.util;

public class JDBCBoardExample {

  public static void main(String[] args) {
    util.startBoard(); // Board 테이블 정의 (최초 한번 실행) - ConnectionFac 필드에서 DB 정보만 수정해 사용가능
    mainMenu();
  }
}


