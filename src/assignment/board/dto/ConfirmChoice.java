package assignment.board.dto;

import static assignment.board.dto.CommonResource.boardList;
import static assignment.board.dto.CommonResource.br;

import assignment.board.vo.Message;
import java.io.IOException;

public class ConfirmChoice {

  public static boolean confirmMenu() {
    while (true) {
      Message.CONFIRM_MENU.getMessage();
      Message.CHOOSE_MENU.getMessage();
      try {
        int select = Integer.parseInt(br.readLine());
        if (select == 1) {
          return true;
        } else if (select == 2) {
          return false;
        } else {
          Message.WRONG_SELECT.getMessage();
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      } catch (NumberFormatException | NullPointerException e) {
        Message.PLEASE_SELECT.getMessage();
      }
    }
  }

  public static boolean checkAgain() {

    Message.DELETE_CONFIRM.getMessage();

    if (confirmMenu()) {
      return true;
    }
    return false;
  }

  public static boolean checkBoardIsEmpty() {
    if (boardList.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }
}
