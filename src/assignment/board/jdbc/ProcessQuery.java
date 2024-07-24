package assignment.board.jdbc;

public interface ProcessQuery {

  void executeQuery(String query);

  void classifyQuery(String query);

  void createBoard(String query);

  void readBoard(String query);

  void updateOrDeleteBoard(String query);

  void clearBoard(String query);

  void showBoardList(String query);
}
