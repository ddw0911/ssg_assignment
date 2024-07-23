package assignment.board.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

  public static String url = "jdbc:://localhost:3306/board";
  public static String id = "root";
  public static String pw = "root";
  public static java.sql.Connection connection;

  public static void connect() {
    try {
      connection = DriverManager.getConnection(url, id, pw);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void close() {
    try {
      connection.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
