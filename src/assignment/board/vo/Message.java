package assignment.board.vo;

import lombok.Getter;

@Getter
public enum Message {
  // 입출력관련
  INPUT_NEW_BOARD("[새 게시물 입력]\n"),
  INPUT_SUCCESS("입력되었습니다.\n"),
  UPDATE_SUCCESS("수정되었습니다.\n"),
  ACTION_CANCEL("취소되었습니다.\n"),
  WRONG_SELECT("올바른 메뉴번호를 입력하세요."),
  PLEASE_SELECT("메뉴를 선택해주세요."),
  INPUT_REQUIRED("입력은 필수입니다."),
  BOARD_NOT_EXISTS("해당 게시물은 존재하지 않습니다."),

  SEARCH_BOARD("[게시물 읽기]\nno: "),
  EXIT_BOARD("**게시물 종료**"),

  // 구분선
  LINE("----------------------------------------------------------------"),
  HASH_LINE("#########"),

  // 메뉴관련
  SHOW_BOARDLIST("[게시물 목록]\n"
      + "----------------------------------------------------------------\n"
      + "no\t\twriter\t\t\t\tdate\t\t\t\t\t\t\t\ttitle\n"
      + "----------------------------------------------------------------"),
  SHOW_MENU("메인 메뉴 : 1.Create | 2.Read | 3.Clear | 4.Exit"),
  CONFIRM_MENU("보조 메뉴: 1.OK | 2.Cancel"),
  CHOOSE_MENU("메뉴 선택: "),
  READ_NEXT_MENU("보조 메뉴: 1. Update | 2. Delete | 3. List"),

  //삭제관련
  DELETE_BOARD("게시물이 삭제되었습니다.\n"),
  CLEAR_BOARD("게시물 목록이 초기화되었습니다.\n"),
  ALREADY_CLEAR("이미 게시물이 초기화되었습니다.\n"),
  DELETE_CONFIRM("정말로 삭제하시겠습니까?\n")

  ;

  private final String message;

  Message(String message) {
    this.message = message;
  }

  public void getMessage() {
    System.out.println(message);
  }
}
