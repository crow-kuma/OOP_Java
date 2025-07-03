package second;

public class Dog extends Canine {
  protected String name;

  public Dog(double size, String name) {
    super(size);
    this.name = name;
  }

  public void fetch() {
    System.out.println("Run");
    System.out.println("Clinch");
    System.out.println("Return");
  }

  public void groom() {
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof Dog)) {
      return false;
    }
    Dog doggy = (Dog) obj;
    return ((doggy.name.equals(name) && doggy.size == size));
  }

  public static void main(String[] args) {
    Dog spot1 = new Dog(9.6, "Spot");
    Dog spot2 = new Dog(9.6, "Spot");
    spot1.bark();
    System.out.println(spot1.equals(spot2));
  }

}
