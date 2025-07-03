package second.hw05;

import java.util.Arrays;
import java.util.List;

public class BlueAstronaut extends Player implements Crewmate {

  private int numTasks;
  private int taskSpeed;

  public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
    super(name, susLevel);
    this.numTasks = numTasks;
    this.taskSpeed = taskSpeed;
  }

  public BlueAstronaut(String name) {
    super(name, 15);
    this.numTasks = 6;
    this.taskSpeed = 10;
  }

  public int getNumTasks() {
    return this.numTasks;
  }

  @Override
  public void completeTask() {
    if (this.isFrozen() || this.numTasks == 0) {
      return;
    }

    if (this.taskSpeed > 20) {
      this.numTasks = -2;
    } else {
      this.numTasks--;
    }
    if (this.numTasks < 0) {
      this.numTasks = 0;
    }

    if (this.numTasks == 0) {
      System.out.println("I have completed all my tasks");
      this.setSusLevel((int) Math.floor(this.getSusLevel() * 0.5f));
    }
  }

  @Override
  public void emergencyMeeting() {
    if (this.isFrozen()) {
      return;
    }

    Player[] players = Player.getPlayers();
    List<Player> nonFrozenPlayers = Arrays.stream(players)
        .filter(p -> !p.isFrozen())
        .toList();
    int maxSusLevel = nonFrozenPlayers.stream()
        .mapToInt(Player::getSusLevel)
        .max()
        .orElse(0);
    List<Player> highestSusPlayers = nonFrozenPlayers.stream()
        .filter(p -> p.getSusLevel() == maxSusLevel)
        .toList();
    if (highestSusPlayers.size() != 1) {
      return;
    } else {
      highestSusPlayers.getFirst().setFrozen(true);
    }

    gameOver();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof BlueAstronaut)) {
      return false;
    } else {
      BlueAstronaut other = (BlueAstronaut) o;
      return super.equals(other) && this.taskSpeed == other.taskSpeed
          && this.numTasks == other.numTasks;
    }
  }

  @Override
  public String toString() {
    String baseString = super.toString();
    String numTaskPart = "I have" + this.numTasks + "left over.";
    if (this.getSusLevel() <= 15) {
      return baseString + numTaskPart;
    } else {
      return baseString.toUpperCase() + numTaskPart.toUpperCase();
    }
  }

}
