package third.HW06;

public class Cat extends Pet {

  int miceCaught;

  public Cat(String name, double health, int painLevel, int miceCaught) {
    super(name, health, painLevel);
    this.miceCaught = miceCaught;

    if (this.miceCaught < 0) {
      this.miceCaught = 0;
    }
  }

  public Cat(String name, double health, int painLevel) {
    super(name, health, painLevel);
    this.miceCaught = 0;
  }

  public int getMiceCaught() {
    return this.miceCaught;
  }

  @Override
  public int treat() {
    int treatmentTime;
    if (miceCaught < 4) {
      treatmentTime = (int) Math.ceil((getPainLevel() * 2) / getHealth());
    } else if (miceCaught <= 7) {
      treatmentTime = (int) Math.ceil(getPainLevel() / getHealth());
    } else {
      treatmentTime = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
    }
    heal();
    return treatmentTime;
  }

  public void speak() {
    super.speak();
    String meow = "meow";
    if (getPainLevel() > 5) {
      meow = "MEOW";
    }

    StringBuilder meows = new StringBuilder(meow);
    for (int i = 0; i < this.miceCaught; i++) {
      meows.append(" ").append(meow);
    }
    System.out.println(meows.toString());
  }

  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    if (!(o instanceof Cat)) {
      return false;
    }
    if (((Cat) o).getMiceCaught() == this.miceCaught) {
      return true;
    }
    return false;
  }

}
