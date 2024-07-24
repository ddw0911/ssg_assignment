package assignment.board.util;

import static assignment.board.jdbc.CRUD.br;
import static assignment.board.jdbc.ConnectionFac.connect;
import static assignment.board.jdbc.ConnectionFac.connection;
import static assignment.board.jdbc.QueryProcessor.processQuery;

import assignment.board.vo.Message;
import java.io.IOException;
import java.sql.SQLException;

public class UtilMethod {

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

  // Board table이 없을때 생성해주는 메서드
  public static void startBoard() {

    String query = "CREATE table if not exists board("
        + "no int unsigned not null auto_increment primary key,"
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

  // 보조메뉴(확인, 취소) 메서드
  public static boolean confirmMenu() {
    while (true) {
      Message.CONFIRM_MENU.getMessage();
      Message.CHOOSE_MENU.getMessage();
      try {
        int select = Integer.parseInt(br.readLine());
        if (select == 1) {
          return true;
        } else if (select == 2) {
          return false;
        } else {
          Message.WRONG_SELECT.getMessage();
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      } catch (NumberFormatException | NullPointerException e) {
        Message.PLEASE_SELECT.getMessage();
      }
    }
  }

  // 삭제를 재확인하는 메서드
  public static boolean deleteCheckAgain() {

    Message.DELETE_CONFIRM.getMessage();

    if (confirmMenu()) {
      return true;
    }
    return false;
  }
}
