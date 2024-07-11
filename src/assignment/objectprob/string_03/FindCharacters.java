package assignment.objectprob.string_03;

public class FindCharacters {
  public static void main(String[] args) {
    FindCharacters fc=new FindCharacters();
    int count=fc.countChar("Boys, be ambitious", 'b');
    System.out.println(count);

  }
  public int countChar(String str, char c) {
    // Method를 완성하세요...
    int result = 0;

//    for (int i = 0; i < str.length(); i++) {
//      if (str.charAt(i) == c) {
//        result++;
//      }
//    }

    char[] ch = str.toCharArray();
    for (char ch1 : ch) {
      if (ch1 == c) {
        result++;
      }
    }
    return result;
  }
}
