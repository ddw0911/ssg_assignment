package assignment.board.jdbc;

import static assignment.board.dto.ConfirmChoice.checkAgain;
import static assignment.board.dto.ConfirmChoice.checkBoardIsEmpty;
import static assignment.board.dto.ConfirmChoice.confirmMenu;
import static assignment.board.dto.CommonResource.br;
import static assignment.board.dto.MainMenu.mainMenu;
import static assignment.board.jdbc.Connection.close;
import static assignment.board.jdbc.Connection.connect;
import static assignment.board.jdbc.Connection.connection;
import static assignment.board.jdbc.QueryProcessor.processQuery;

import assignment.board.vo.Message;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class CRUD {

  public static void startBoard() {

    String query = "CREATE table if not exists board("
        + "id int unsigned not null auto_increment primary key,"
        + "title varchar(50) not null,"
        + "content varchar(255) not null,"
        + "writer varchar(30) not null,"
        + "date date not null);";

    try {
      connect();
      processQuery.executeQuery(query);
      connection.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void create() {
    String query = "INSERT INTO board VALUES(?,?,?,?,?)";
    Message.INPUT_NEW_BOARD.getMessage();
    connect();
    processQuery.executeQuery(query);
    close();
  }

  public static void read() {
    try {
      int searchBoard = Integer.parseInt(br.readLine());
      String query = "SELECT * FROM board where no=" + searchBoard;
      Message.SEARCH_BOARD.getMessage();

      connect();
      processQuery.executeQuery(query);
      close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // 게시물을 찾았을때 실행되는 메뉴
  public static void nextMenu(int boardNo) {
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
    String title = inputRequired("제목");
    String content = inputRequired("내용");
    String writer = inputRequired("작성자");
    LocalDate date = LocalDate.now();
    StringBuilder query = new StringBuilder()
        .append("UPDATE board SET title = " + title)
        .append("content = " + content)
        .append("writer = " + writer)
        .append("date = " + date);

    if (confirmMenu()) {
      connect();
      processQuery.executeQuery(String.valueOf(query));
      close();
      Message.UPDATE_SUCCESS.getMessage();
    } else {
      Message.ACTION_CANCEL.getMessage();
    }
  }

  public static void delete(int searchedBoardNo) {
    String query = "DELETE * FROM board no = " + searchedBoardNo;
    connect();

    if (checkAgain()) {
      processQuery.executeQuery(query);
      close();
      Message.DELETE_BOARD.getMessage();
    } else {
      Message.ACTION_CANCEL.getMessage();
    }
  }

  public static void clear() {
    String query = "DELETE * FROM board";

    if (!checkBoardIsEmpty()) {
      if (checkAgain()) {
        processQuery.executeQuery(query);
        Message.CLEAR_BOARD.getMessage();
      } else {
        Message.ACTION_CANCEL.getMessage();
      }
    } else {
      Message.ALREADY_CLEAR.getMessage();
    }
  }

  //항목 필수입력처리 메서드
  public static String inputRequired(String subject) {
    String input;
    while (true) {
      try {
        System.out.print(subject + ": ");
        input = br.readLine();

        if (input.trim().isBlank()) {
          Message.INPUT_REQUIRED.getMessage();
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

