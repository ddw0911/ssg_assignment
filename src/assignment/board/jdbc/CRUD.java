package assignment.board.jdbc;

import static assignment.board.dto.MainMenu.mainMenu;
import static assignment.board.jdbc.ConnectionFac.close;
import static assignment.board.jdbc.ConnectionFac.connect;
import static assignment.board.jdbc.QueryProcessor.processQuery;
import static assignment.board.util.UtilMethod.confirmMenu;
import static assignment.board.util.UtilMethod.deleteCheckAgain;
import static assignment.board.util.UtilMethod.inputRequired;

import assignment.board.vo.Message;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class CRUD {

  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void create() {
    String query = "INSERT INTO board (title, content, writer, date) VALUES(?,?,?,?)";
    Message.INPUT_NEW_BOARD.getMessage();
    connect();
    processQuery.executeQuery(query);
    close();
  }

  public static void read() {
    try {
      Message.SEARCH_BOARD.getMessage();
      int searchBoard = Integer.parseInt(br.readLine());
      String query = "SELECT * FROM board where no=" + searchBoard;

      connect();
      processQuery.executeQuery(query);
      close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // 게시물을 찾았을때 실행되는 메뉴
  public static void readSecondMenu(int boardNo) {
    Message.READ_NEXT_MENU.getMessage();
    Message.CHOOSE_MENU.getMessage();
    try {
      int select = Integer.parseInt(br.readLine());
      switch (select) {
        case 1 -> update(boardNo);
        case 2 -> delete(boardNo);
        case 3 -> mainMenu();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void update(int searchedBoardNo) {
    int no = searchedBoardNo;
    String title = inputRequired("제목");
    String content = inputRequired("내용");
    String writer = inputRequired("작성자");
    LocalDate date = LocalDate.now();
    String query = new StringBuilder()
        .append("UPDATE board SET title = '" + title)
        .append("' ,content = '" + content)
        .append("' ,writer = '" + writer)
        .append("' ,date = '" + date)
        .append("' where no = " + no)
        .toString();

    if (confirmMenu()) {
      connect();
      processQuery.executeQuery(query);
      close();
      Message.UPDATE_SUCCESS.getMessage();
    } else {
      Message.ACTION_CANCEL.getMessage();
    }
  }

  public static void delete(int searchedBoardNo) {
    String query = "DELETE FROM board where no = " + searchedBoardNo;
    connect();

    if (deleteCheckAgain()) {
      processQuery.executeQuery(query);
      close();
      Message.DELETE_BOARD.getMessage();
    } else {
      Message.ACTION_CANCEL.getMessage();
    }
  }

  public static void clear() {
    String query = "TRUNCATE table board";

    if (deleteCheckAgain()) {
      connect();
      processQuery.executeQuery(query);
      close();
      Message.CLEAR_BOARD.getMessage();
    } else {
      Message.ACTION_CANCEL.getMessage();
    }
  }
}

