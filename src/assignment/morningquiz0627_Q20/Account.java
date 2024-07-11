package assignment.morningquiz0627_Q20;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Account {

  String accNum;
  String accOwner;
  int balance;
}
