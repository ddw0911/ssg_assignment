package assignment.objectprob.prob1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Vehicle{

  private Owner owner;
  private int price;

  @Override
  public boolean equals(Object obj) {
    if (this.getOwner().equals(obj)) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "소유주정보 : 이름은 " + this.owner.getName() +
        "이고, 핸드폰 번호는 " + this.owner.getCellPhone() +
        "입니다.\n차량정보 : 가격은 " + this.getPrice() + "입니다.";
  }
}
