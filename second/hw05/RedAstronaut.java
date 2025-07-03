package second.hw05;

import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {

  private String skill;

  public RedAstronaut(String name, int susLevel, String skill) {
    super(name, susLevel);
    this.skill = skill;
  }

  public RedAstronaut(String name) {
    super(name, 15);
    skill = "experienced";
  }

  /**
   * This method is called when the Red Astronaut freezes a player.
   */
  @Override
  public void freeze(Player p) {
    if (p instanceof Impostor || this.isFrozen() || p.isFrozen()) {
      return;
    }

    if (p.getSusLevel() > this.getSusLevel()) {
      p.setFrozen(true);
    } else {
      this.setSusLevel(this.getSusLevel() * 2);
    }

    gameOver();

  }

  @Override
  public void sabotage(Player p) {
    if (p instanceof Impostor || this.isFrozen() || p.isFrozen()) {
      return;
    }

    if (this.getSusLevel() < 20) {
      p.setSusLevel((int) Math.floor(p.getSusLevel() * 1.5f));
    } else {
      p.setSusLevel((int) Math.floor(p.getSusLevel() * 1.25f));
    }
  }

  /**
   * This method is called when an emergency meeting is initiated.
   */
  @Override
  public void emergencyMeeting() {
    if (this.isFrozen()) {
      return;
    }

    // Find the highest susLevel among NON-IMPOSTOR players
    Player[] allPlayers = Player.getPlayers();
    Player[] nonImpostors = Arrays.stream(allPlayers)
        .filter(player -> !(player instanceof Impostor) && player != null)
        .toArray(Player[]::new);

    if (nonImpostors.length == 0) {
      return;
    }

    int highestSusLevel = Arrays.stream(nonImpostors)
        .mapToInt(Player::getSusLevel)
        .max()
        .orElse(0);

    Player[] playersWithMaxSus = Arrays.stream(nonImpostors)
        .filter(player -> player.getSusLevel() == highestSusLevel)
        .toArray(Player[]::new);

    if (playersWithMaxSus.length != 1) {
      return;
    } else {
      freeze(playersWithMaxSus[0]);
    }

    gameOver();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof RedAstronaut)) {
      return false;
    } else {
      RedAstronaut other = (RedAstronaut) o;
      return super.equals(other) && this.skill.equals(other.skill);
    }
  }

  @Override
  public String toString() {
    String baseString = super.toString();
    String skillPart = " I am an " + this.skill + " player!";
    if (this.getSusLevel() <= 15) {
      return baseString + skillPart;
    } else {
      return baseString.toUpperCase() + skillPart.toUpperCase();
    }
  }

}
