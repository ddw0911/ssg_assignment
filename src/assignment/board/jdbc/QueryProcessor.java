package assignment.board.jdbc;

import static assignment.board.jdbc.CRUD.readSecondMenu;
import static assignment.board.jdbc.ConnectionFac.connection;
import static assignment.board.util.UtilMethod.util;

import assignment.board.dto.Board;
import assignment.board.vo.Message;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class QueryProcessor implements ProcessQuery {

  public static ProcessQuery processQuery = new QueryProcessor();

  public static PreparedStatement pstmt;

  public static ResultSet rs;

  @Override
  public void executeQuery(String query) {
    try {
      pstmt = connection.prepareStatement(query);
      classifyQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void classifyQuery(String query) {
    try {
      switch (getQueryType(query)) {
        case "SHOW_BOARDLIST":
          processQuery.showBoardList(query);
          break;
        case "INSERT":
          processQuery.createBoard(query);
          Message.LINE.getMessage();
          if (util.confirmMenu()) {
            pstmt.executeUpdate();
            pstmt.close();
            Message.INPUT_SUCCESS.getMessage();
          } else {
            Message.ACTION_CANCEL.getMessage();
          }
          break;
        case "SELECT":
          processQuery.readBoard(query);
          break;
        case "UPDATE":
        case "DELETE":
        case "TRUNCATE":
          processQuery.updateOrDeleteBoard(query);
          break;
        default:
          pstmt.executeUpdate();
          pstmt.close();
          break;
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void showBoardList(String query) {

    try {
      rs = pstmt.executeQuery();
      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("no"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
        board.setWriter(rs.getString("writer"));
        board.setDate(rs.getDate("date"));
        System.out.println(board);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (NullPointerException e) {
    }
  }

  @Override
  public void createBoard(String query) {
    try {
      pstmt.setString(1, util.inputRequired("제목"));
      pstmt.setString(2, util.inputRequired("내용"));
      pstmt.setString(3, util.inputRequired("작성자"));
      pstmt.setDate(4, Date.valueOf(LocalDate.now()));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void readBoard(String query) {
    try {
      rs = pstmt.executeQuery(query);

      if (rs.next()) {
        Board board = new Board();

        board.setNo(rs.getInt("no"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
        board.setWriter(rs.getString("writer"));
        board.setDate(rs.getDate("date"));

        rs.close();
        pstmt.close();

        Message.HASH_LINE.getMessage();
        board.getBoardInfo();
        Message.HASH_LINE.getMessage();
        readSecondMenu(board.getNo());
      } else {
        Message.BOARD_NOT_EXISTS.getMessage();
      }
    } catch (SQLException e) {
      Message.BOARD_NOT_EXISTS.getMessage();
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void updateOrDeleteBoard(String query) {
    try {
      pstmt.execute(query);
      pstmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static String getQueryType(String query) {
    if (query.contains("SELECT * FROM board ORDER BY no DESC")) return "SHOW_BOARDLIST";
    if (query.contains("INSERT")) return "INSERT";
    if (query.contains("SELECT")) return "SELECT";
    if (query.contains("UPDATE")) return "UPDATE";
    if (query.contains("DELETE")) return "DELETE";
    if (query.contains("TRUNCATE")) return "TRUNCATE";
    return "DEFAULT";
  }
}
