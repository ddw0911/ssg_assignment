package assignment.interface_.Q1;

public class AnimalTest {

  public static void main(String[] args) {
    Animal dog = new Dog(8);
    Animal chicken = new Chicken(3);
    Cheatable cheatableChicken = new Chicken(5);
    Chicken cheat = (Chicken) cheatableChicken;
    if (cheat instanceof Cheatable) {
      cheat.fly();
      for (int i = 1; i <= 3; i++) {
        System.out.println(i + "시간 후");
        dog.run(i);
        chicken.run(i);
        System.out.println("닭의 이동거리=" + chicken.getDistance());
        cheat.run(i);
        System.out.println("날으는 닭의 이동거리=" + cheat.getDistance());

      }
    }
  }
}
