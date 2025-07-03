package second;

public class Frog {
  private String name;
  private int age;
  private double tongueSpeed;
  private boolean isFroglet;
  private String species;

  public Frog(String name, int age, double tongueSpeed) {
    this.name = name;
    this.age = age;
    this.tongueSpeed = tongueSpeed;
    this.isFroglet = age > 1 && age < 7;
    this.species = "Rare Pepe";
  }

  public Frog(String name, double ageInYears, double tongueSpeed) {
    this(name, (int) (ageInYears * 12), tongueSpeed);
  }

  public Frog(String name) {
    this(name, 5, 5);
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public void grow(int months) {
    for (int i = 0; i < months; i++) {
      age++;
      if (age <= 12) {
        tongueSpeed++;
      } else if (age >= 30 && tongueSpeed > 5) {
        tongueSpeed--;
      }
    }
    isFroglet = age > 1 && age < 7;
  }

  private void grow() {
    grow(1);
  }

  public void eat(Fly fly) {
    if (fly.isDead()) {
      return;
    }
    if (tongueSpeed > fly.getSpeed()) {
      if (fly.getMass() >= 0.5 * age) {
        grow();
        fly.setMass(0);
      }
    } else {
      fly.grow(1);
    }
  }

  public String toString() {
    if (isFroglet) {
      return String.format(
          "My name is %s and I'm a rare froglet! I'm %d months old and my tongue has a speed of %.2f.",
          name, age, tongueSpeed);
    } else {
      return String.format("My name is %s and I'm a rare frog. I'm %d months old and my tongue has a speed of %.2f.",
          name, age, tongueSpeed);
    }
  }
}
