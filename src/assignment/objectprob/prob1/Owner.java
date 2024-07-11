package assignment.objectprob.prob1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Owner {

  private String name;
  private String cellPhone;

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Owner owner) {
      if (owner.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }


  @Override
  public String toString() {
    return "이름은 " + name + "이고, 핸드폰 번호는 " + cellPhone;
  }
}
