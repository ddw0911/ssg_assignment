package assignment.board;

import static assignment.board.jdbccrud.Create.setPstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCConnect {
  public static String url = "jdbc:://localhost:3306/board";
  public static String id = "root";
  public static String pw = "root";
  public static Connection connection;
  public static PreparedStatement pstmt;

  public void startBoard() {

    String query = "Create table if not exists board("
        + "id int not null,"
        + "title varchar(255) not null,"
        + "content varchar(255) not null,"
        + "writer varchar(255) not null,"
        + "date date not null);";

    try {
      connect();
      executePstmt(query);
      connection.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static Connection connect() {
    try {
      connection = DriverManager.getConnection(url, id, pw);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return connection;
  }

  public static void executePstmt(String query) {
    try {
      pstmt = connection.prepareStatement(query);
      isPlaceHolder(query);
      pstmt.executeUpdate();
      pstmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static void isPlaceHolder(String query) {
    if (query.contains("?")) {
        setPstmt(query);
      }
    }
  }
