package second;

public abstract class Canine implements Groomable {
  protected double size;

  public Canine(double size) {
    this.size = size;
  }

  public void bark() {
    System.out.println("Woof woof");
  }
}
