package second;

public class GroomEverything {
  public static void main(String[] args) {
    Groomable[] groomer = {
        new Wolf(17.01, 3),
        new Poodle(9, "richie", "lux brand", "rich brand"),
        new Wolf(16, 5),
        new Poodle(4, "pixy", "top shelf", "only the best"),
        new Car("Yuhina", "Spark", 2038)
    };

    for (Groomable g : groomer) {
      g.groom();
      g.pay();
    }
  }
}
