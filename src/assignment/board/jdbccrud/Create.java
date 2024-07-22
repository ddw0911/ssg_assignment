package assignment.board.jdbccrud;

import static assignment.board.CommonResource.boardCount;
import static assignment.board.CommonResource.boardList;
import static assignment.board.CommonResource.br;
import static assignment.board.JDBCConnect.connect;
import static assignment.board.JDBCConnect.connection;
import static assignment.board.JDBCConnect.executePstmt;
import static assignment.board.JDBCConnect.pstmt;
import static assignment.board.PrintMenu.confirmMenu;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Create {

  public static void create() {
    String query = "INSERT INTO board VALUES(?,?,?,?,?)";
    System.out.println("[새 게시물 입력]");

    connect();
    executePstmt(query);

    System.out.println("----------------------------------------------------------------");

    if (confirmMenu()) {
      board.setNo(boardCount);
      board.setDate(Date.valueOf(LocalDate.now()));
      System.out.println("입력되었습니다.");
      boardList.add(board);
      boardCount++;
    } else {
      System.out.println("입력이 취소되었습니다.");
    }
    System.out.println();
  }

  //항목 필수입력처리 메서드
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

  public static void setPstmt(String query) {
    try {
      pstmt.setInt(1, boardCount);
      pstmt.setString(2, inputRequired("제목"));
      pstmt.setString(3, inputRequired("내용"));
      pstmt.setString(4, inputRequired("작성자"));
      pstmt.setDate(5, Date.valueOf(LocalDate.now()));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
