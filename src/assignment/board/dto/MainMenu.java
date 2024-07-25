package assignment.board.dto;

import static assignment.board.dto.Board.showBoardList;
import static assignment.board.jdbc.CRUD.br;
import static assignment.board.jdbc.CRUD.clear;
import static assignment.board.jdbc.CRUD.create;
import static assignment.board.jdbc.CRUD.read;
import static assignment.board.util.UtilMethod.util;

import assignment.board.vo.Message;
import java.io.IOException;

public class MainMenu {

  public static void mainMenu() {
    while (true) {
      Message.SHOW_BOARDLIST.getMessage();
      showBoardList();
      Message.SHOW_MENU.getMessage();

      try {
        int select = Integer.parseInt(util.inputRequired("메뉴 선택"));
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
      } catch (NumberFormatException | NullPointerException e) {
        Message.PLEASE_SELECT.getMessage();
      }
    }
  }


}
