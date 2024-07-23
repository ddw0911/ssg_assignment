package assignment.board.dto;

import static assignment.board.jdbc.Connection.close;
import static assignment.board.jdbc.Connection.connect;
import static assignment.board.jdbc.QueryProcessor.processQuery;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Board {

  private int no;
  private String title;
  private String content;
  private String writer;
  private Date date;


  @Override
  public String toString() {
    return this.getNo() + "\t\t\t" + this.getWriter() + "\t\t\t\t\t\t" + this.getDate() + "\t\t\t\t\t" + this.getTitle();
  }

  public void getBoardInfo() {
    System.out.println("번호: " + this.getNo());
    System.out.println("제목: " + this.getTitle());
    System.out.println("내용: " + this.getContent());
    System.out.println("작성자: " + this.getWriter());
    System.out.println("날짜: " + this.getDate());
  }

  //게시물 목록 출력
  static void  showBoardList() {
    String query = "SELECT * FROM board";
    connect();
    processQuery.executeQuery(query);
    close();
//    boardList.sort(Comparator.comparing(Board::getNo).reversed());
//    boardList.forEach(System.out::println);
  }
}