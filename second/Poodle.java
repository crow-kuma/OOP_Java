package second;

public class Poodle extends Dog {
  private String favoriteShampoo;
  private String favoriteConditioner;

  public Poodle(double size, String name, String favoriteShampoo, String favoriteConditioner) {
    super(size, name);
    this.favoriteShampoo = favoriteShampoo;
    this.favoriteConditioner = favoriteConditioner;
  }

  public void groom() {
    System.out.println(favoriteShampoo + " rinse " + favoriteConditioner + " wait 10 mins " + "dry and massage");
  }

}
