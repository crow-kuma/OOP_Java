package third.HW06;

public class Dog extends Pet {
  double droolRate;

  public Dog(String name, double health, int painLevel, double droolRate) {
    super(name, health, painLevel);
    this.droolRate = droolRate;

    if (this.droolRate <= 0) {
      this.droolRate = 0.5;
    }
  }

  public Dog(String name, double health, int painLevel) {
    super(name, health, painLevel);
    this.droolRate = 5.0;
  }

  public double getDroolRate() {
    return this.droolRate;
  }

  @Override
  public int treat() {
    int treatmentTime;
    if (droolRate < 3.5) {
      treatmentTime = (int) Math.ceil((getPainLevel() * 2) / getHealth());
    } else if (droolRate <= 7.5) {
      treatmentTime = (int) Math.ceil(getPainLevel() / getHealth());
    } else {
      treatmentTime = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
    }
    heal();
    return treatmentTime;
  }

  public void speak() {
    super.speak();
    String bark = "bark";
    if (getPainLevel() > 5) {
      bark = "BARK";
    }

    StringBuilder barks = new StringBuilder(bark);
    for (int i = 1; i < getPainLevel(); i++) {
      barks.append(" ").append(bark);
    }
    System.out.println(barks.toString());
  }

  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    if (!(o instanceof Dog)) {
      return false;
    }
    if (((Dog) o).getDroolRate() == this.droolRate) {
      return true;
    }
    return false;
  }

}
