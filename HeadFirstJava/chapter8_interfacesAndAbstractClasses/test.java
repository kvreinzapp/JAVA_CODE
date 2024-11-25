import java.util.ArrayList;

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
    ArrayList<Animal> list = new ArrayList<Animal>();
    dog aDog = new dog();
    list.add(aDog);
    dog d = list.get(0);
  }
}


public Object getObject(Object o){
	return o;
}

public void go(){
	Dog aDog = new Dog();
	Dog sameDog = getObject(aDog);
}
