package second;

public interface Groomable {
  public void groom();

  default void pay() {
    System.out.println("Cha-ching!");
  };

  static String calculateTip(double price, double percentage) {
    double rawTip = price * (percentage / 100);
    return String.format("$%,.2f", rawTip);
  }
}
