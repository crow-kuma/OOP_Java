package third.HW06;

public abstract class Pet {
  String name;
  double health;
  int painLevel;

  public Pet(String name, double health, int painLevel) {
    this.name = name;
    this.health = health;
    this.painLevel = painLevel;

    if (this.health > 1.0) {
      this.health = 1.0;
    } else if (this.health < 0.0) {
      this.health = 0.0;
    }

    if (this.painLevel < 1) {
      this.painLevel = 1;
    } else if (this.painLevel > 10) {
      this.painLevel = 10;
    }
  }

  public String getName() {
    return name;
  }

  public double getHealth() {
    return health;
  }

  public int getPainLevel() {
    return painLevel;
  }

  public abstract int treat();

  public void speak() {
    var message = "Hello! My name is " + name;
    if (painLevel >= 5) {
      System.out.println(message.toUpperCase());
    } else {
      System.out.println(message);
    }
  }

  public boolean equals(Object o) {
    if (!(o instanceof Pet)) {
      return false;
    }
    Pet pet = (Pet) o;
    if (pet.getName().equals(name)) {
      return true;
    }
    return false;
  }

  protected void heal() {
    this.health = 1.0;
    this.painLevel = 1;
  }
}
