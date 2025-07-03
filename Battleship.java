import java.util.Scanner;

public class Battleship {
	private static final int BOARD_SIZE = 5;
	private static char[][] player1Ships = new char[BOARD_SIZE][BOARD_SIZE];
	private static char[][] player1PlayBoard = new char[BOARD_SIZE][BOARD_SIZE];
	private static char[][] player2Ships = new char[BOARD_SIZE][BOARD_SIZE];
	private static char[][] player2PlayBoard = new char[BOARD_SIZE][BOARD_SIZE];
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to Battleship!");
		System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
		storeCoordinates(player1Ships);
		printBattleShip(player1Ships);
		hundredNewLine();

		System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
		storeCoordinates(player2Ships);
		printBattleShip(player2Ships);
		hundredNewLine();

		boolean isThereWinner = false;
		while (!isThereWinner) {
			storePlayBoard(player1PlayBoard, player2Ships, "Player 1", "Player 2");
			isThereWinner = countHit(player1PlayBoard, "PLAYER 1");
			if (isThereWinner) {
				break;
			}

			storePlayBoard(player2PlayBoard, player1Ships, "Player 2", "Player 1");
			isThereWinner = countHit(player2PlayBoard, "PLAYER 2");
		}

		input.close();

	}

	/**
	 * This method stores the player's hits on the play board.
	 * 
	 * @param playerPlayBoard
	 * @param opponentShips
	 * @param player
	 * @param opponent
	 */
	private static void storePlayBoard(char[][] playerPlayBoard, char[][] opponentShips, String player, String opponent) {
		System.out.printf("%s, enter hit row/column:%n", player);
		int[] coordinates = getValidCoordinates(playerPlayBoard);
		int row = coordinates[0];
		int column = coordinates[1];
		player = player.toUpperCase();
		opponent = opponent.toUpperCase();
		if (opponentShips[row][column] == '@') {
			playerPlayBoard[row][column] = 'X';
			System.out.printf("%s HIT %s's SHIP!%n", player, opponent);
		} else {
			playerPlayBoard[row][column] = 'O';
			System.out.printf("%s MISSED!%n", player);
		}
		printBattleShip(playerPlayBoard);
	}

	/**
	 * This method stores the coordinates of the ships for each player.
	 * 
	 * @param player
	 */
	private static void storeCoordinates(char[][] player) {
		for (int i = 0; i < 5; i++) {
			System.out.print("Enter ship " + (i + 1) + " location: ");
			int[] coordinates = getValidCoordinates(player);
			player[coordinates[0]][coordinates[1]] = '@';
		}
	}

	/**
	 * This method gets valid coordinates from the user.
	 * 
	 * @return int[] - an array of two integers representing the row and column
	 */
	private static int[] getValidCoordinates(char[][] ships) {
		int row, column;
		while (true) {
			row = input.nextInt();
			column = input.nextInt();
			if (row >= BOARD_SIZE || column >= BOARD_SIZE) {
				System.out.println("Invalid coordinates. Choose different coordinates.");
				System.out.print("Enter ship location: ");
			} else if (ships[row][column] == '@') {
				System.out.println("You already have a ship there. Choose different coordinates.");
				System.out.print("Enter ship location: ");
			} else if (ships[row][column] == 'O' || ships[row][column] == 'X') {
				System.out.println("You already fired on this spot. Choose different coordinates.");
				System.out.print("Enter hit row/column: ");
			} else {
				break;
			}
		}
		return new int[] { row, column };
	}

	// Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else if (player[row][column] != '\u0000') {
					System.out.print(player[row][column] + " ");
				} else {
					System.out.print("- ");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}

	/**
	 * This method counts the number of hits on the play board.
	 * 
	 * @param playerPlayBoard
	 * @param player
	 * @return boolean - true if there are 5 hits, false otherwise
	 */
	private static boolean countHit(char[][] playerPlayBoard, String player) {
		int hitCount = 0;
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int column = 0; column < BOARD_SIZE; column++) {
				if (playerPlayBoard[row][column] == 'X') {
					hitCount++;
				}
			}
		}
		if (hitCount == 5) {
			System.out.printf("%s WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!%n", player);
			return true;
		}
		return false;
	}

	/**
	 * This method prints 100 new lines to the console.
	 */
	private static void hundredNewLine() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
}
