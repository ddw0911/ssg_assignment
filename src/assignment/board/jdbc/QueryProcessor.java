package assignment.board.jdbc;

import static assignment.board.dto.ConfirmChoice.confirmMenu;
import static assignment.board.dto.CommonResource.boardCount;
import static assignment.board.jdbc.CRUD.inputRequired;
import static assignment.board.jdbc.CRUD.nextMenu;
import static assignment.board.jdbc.Connection.connection;

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

  public void executeQuery(String query) {
    try {
      pstmt = connection.prepareStatement(query);
      classifyQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void classifyQuery(String query) {
    try {
      if (query.contains("INSERT")) {
        processQuery.createBoard(query);
        Message.LINE.getMessage();
        if (confirmMenu()) {
          pstmt.executeUpdate();
          pstmt.close();
          Message.INPUT_SUCCESS.getMessage();
        } else {
          Message.ACTION_CANCEL.getMessage();
        }
      } else if (query.contains("SELECT")) {
        processQuery.readBoard(query);
      } else if (query.contains("UPDATE") || query.contains("DELETE")) {
        processQuery.updateOrDeleteBoard(query);
      } else {
        pstmt.executeUpdate();
        pstmt.close();
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void createBoard(String query) {
    try {
      pstmt.setInt(1, boardCount);
      pstmt.setString(2, inputRequired("제목"));
      pstmt.setString(3, inputRequired("내용"));
      pstmt.setString(4, inputRequired("작성자"));
      pstmt.setDate(5, Date.valueOf(LocalDate.now()));
      boardCount++;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void readBoard(String query) {
    try {
      ResultSet rs = pstmt.executeQuery(query);
      if (String.valueOf(rs.getInt("no")) != null) {
        Board board = new Board();
        while (rs.next()) {
          board.setNo(rs.getInt("no"));
          board.setTitle(rs.getString("title"));
          board.setContent(rs.getString("content"));
          board.setWriter(rs.getString("writer"));
          board.setDate(rs.getDate("date"));
        }
        rs.close();
        pstmt.close();
        Message.HASH_LINE.getMessage();
        board.getBoardInfo();
        Message.HASH_LINE.getMessage();
        nextMenu(board.getNo());
      } else {
        Message.BOARD_NOT_EXISTS.getMessage();
        rs.close();
        pstmt.close();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (NullPointerException e) {
      e.getMessage();
    }
  }

  public void updateOrDeleteBoard(String query) {
    try {
      pstmt.executeUpdate(query);
      pstmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
