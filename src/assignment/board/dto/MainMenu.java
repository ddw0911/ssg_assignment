package assignment.board.dto;

import static assignment.board.crud.Read.read;
import static assignment.board.dto.Board.showBoardList;
import static assignment.board.dto.CommonResource.br;
import static assignment.board.jdbc.CRUD.clear;
import static assignment.board.jdbc.CRUD.create;

import assignment.board.vo.Message;
import java.io.IOException;

public class MainMenu {

  public static void mainMenu() {
    while (true) {
      Message.SHOW_BOARDLIST.getMessage();
      showBoardList();
      Message.SHOW_MENU.getMessage();
      Message.CHOOSE_MENU.getMessage();

      try {
        int select = Integer.parseInt(br.readLine());
        System.out.println();

        switch (select) {
          case 1 -> create();
          case 2 -> read();
          case 3 -> clear();
          case 4 -> {
            Message.EXIT_BOARD.getMessage();
            return;
          }
          default -> Message.WRONG_SELECT.getMessage();
        }
      } catch (IOException e) {
        e.printStackTrace();
      } catch (NumberFormatException | NullPointerException e) {
        Message.PLEASE_SELECT.getMessage();
      }
    }
  }
}
