class Animal {
  void fight() {
    System.out.println("i am fighting.");
  }
}

class dog extends Animal {
  void bite() {
    System.out.println("i am biting.");
  }
}

public class test {
  public static void main(String[] args) {
    Object o = new dog();
    System.out.println(o.getClass());
  }
}
