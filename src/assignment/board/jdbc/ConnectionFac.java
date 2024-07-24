package assignment.board.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFac {

  public static String url = "jdbc:mysql://localhost:3306/board";
  public static String id = "root";
  public static String pw = "root";
  public static Connection connection;

  public static Connection connect() {
    try {
      connection = DriverManager.getConnection(url, id, pw);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return connection;
  }

  public static void close() {
    try {
      connection.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
