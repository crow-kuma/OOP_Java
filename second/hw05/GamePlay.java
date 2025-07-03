package second.hw05;

public class GamePlay {
  BlueAstronaut bobBlueAstronaut = new BlueAstronaut("Bob", 20, 6, 30);
  BlueAstronaut heathBlueAstronaut = new BlueAstronaut("Heath", 30, 3, 21);
  BlueAstronaut albertBlueAstronaut = new BlueAstronaut("Albert", 44, 2, 0);
  BlueAstronaut angelBlueAstronaut = new BlueAstronaut("Angel", 0, 1, 0);
  RedAstronaut liamRedAstronaut = new RedAstronaut("Liam", 19, "experienced");
  RedAstronaut suspiciousRedAstronaut = new RedAstronaut("Suspicious Person", 100, "expert");

  public void play() {
    liamRedAstronaut.sabotage(bobBlueAstronaut);
    System.out.println("Liam sabotaged Bob's sus level: " + bobBlueAstronaut.getSusLevel() + " frozen: "
        + bobBlueAstronaut.isFrozen());

    liamRedAstronaut.freeze(suspiciousRedAstronaut);
    System.out.println("Liam froze the suspicious person: " + suspiciousRedAstronaut.getSusLevel() + " frozen: "
        + suspiciousRedAstronaut.isFrozen());

    liamRedAstronaut.freeze(albertBlueAstronaut);
    System.out.println("Liam froze Albert. Albert's sus level: " + albertBlueAstronaut.getSusLevel() + " frozen: "
        + albertBlueAstronaut.isFrozen());
    System.out.println("Liam's sus level: " + liamRedAstronaut.getSusLevel() + " frozen: "
        + liamRedAstronaut.isFrozen());

    albertBlueAstronaut.emergencyMeeting();
    System.out.println("Albert called an emergency meeting. But nothing happened to him since he is frozen.");

    suspiciousRedAstronaut.emergencyMeeting();
    System.out.println(
        "Suspicious person called an emergency meeting. But nothing happened because Bob and Heath has tied sus levels.");
    System.out.println("Bob's sus level: " + bobBlueAstronaut.getSusLevel() + " frozen: "
        + bobBlueAstronaut.isFrozen());
    System.out.println("Heath's sus level: " + heathBlueAstronaut.getSusLevel() + " frozen: "
        + heathBlueAstronaut.isFrozen());

    bobBlueAstronaut.emergencyMeeting();
    System.out.println("Bob called an emergency meeting and the Suspicious Person is frozen: "
        + suspiciousRedAstronaut.isFrozen());

    for (int i = 0; i < 2; i++) {
      heathBlueAstronaut.completeTask();
      System.out.println("Heath completed a task. His sus level is now: " + heathBlueAstronaut.getSusLevel()
          + " numTask: " + heathBlueAstronaut.getNumTasks());
    }

    liamRedAstronaut.freeze(angelBlueAstronaut);
    System.out.println("Liam froze Angel. Angel's sus level: " + angelBlueAstronaut.getSusLevel() + " frozen: "
        + angelBlueAstronaut.isFrozen());
    System.out.println("Liam's sus level: " + liamRedAstronaut.getSusLevel() + " frozen: "
        + liamRedAstronaut.isFrozen());

    for (int i = 0; i < 2; i++) {
      liamRedAstronaut.sabotage(bobBlueAstronaut);
      System.out.println("Liam sabotaged Bob. Bob's sus level: " + bobBlueAstronaut.getSusLevel() + " frozen: "
          + bobBlueAstronaut.isFrozen());
    }

    liamRedAstronaut.freeze(bobBlueAstronaut);
    System.out.println("Liam froze Bob. Bob's sus level: " + bobBlueAstronaut.getSusLevel() + " frozen: "
        + bobBlueAstronaut.isFrozen());

    // Scenario where Crewmates win.
    // angelBlueAstronaut.emergencyMeeting();
    // System.out.println("Angel called an emergency meeting. Liam is frozen: "
    // + liamRedAstronaut.isFrozen());

    // Scenario where Impostors win.
    for (int i = 0; i < 5; i++) {
      liamRedAstronaut.sabotage(heathBlueAstronaut);
      System.out.println("Liam sabotaged Heath. Heath's sus level: " + heathBlueAstronaut.getSusLevel() + " frozen: "
          + heathBlueAstronaut.isFrozen());
    }
    liamRedAstronaut.freeze(heathBlueAstronaut);
    System.out.println("Liam froze Heath. Heath's sus level: " + heathBlueAstronaut.getSusLevel() + " frozen: "
        + heathBlueAstronaut.isFrozen());
  }

  public static void main(String[] args) {
    GamePlay game = new GamePlay();
    game.play();
  }
}
