package second.hw05;

/**
 * Interface for Impostor actions in a game.
 * Defines methods for freezing and sabotaging players.
 */
public interface Impostor {

  /**
   * Freezes a player, preventing them from performing actions.
   * 
   * @param p
   */
  public void freeze(Player p);

  /**
   * Sabotages a player, causing them to be unable to perform actions for a
   * certain period.
   * 
   * @param p
   */
  public void sabotage(Player p);
}
