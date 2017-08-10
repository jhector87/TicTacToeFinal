import java.util.Scanner;

/**
 * @author jonathanhector on 27.02.17.
 */
public class Game {
	private String name;
	private final int ROW = 2;
	private final int COL = 2;
	private char[][] board;
	private Scanner input = new Scanner(System.in);
	private char playerTurn = 'X';
	private boolean winCheck = false;


	public Game(Prompter prompt) {
		name = prompt.getName();
		board = new char[3][3];
		showBoard();
		boardInitializer();
	}

	private void showBoard() {
		System.out.println("-------------");
		for(int i = 0; i < 3; i++) {
			System.out.print("| ");
			for(int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	private void boardInitializer() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
	}

	private void playerTurnChange() {
		if(playerTurn == 'X') {
			System.out.println("It's 'O' turn");
			playerTurn = 'O';
		} else {
			playerTurn = 'X';
			if(name.isEmpty()) {
				System.out.println("It's 'X' turn");
			} else {
				System.out.printf("It's %s's turn\n", name);
			}
		}
		isWin();
		play();
	}

	public char[][] play() {
		while(!winCheck) {
			boardInput();
			isWin();
		}
		return board;
	}

	private char[][] boardInput() {
		if(name.isEmpty()) {
			System.out.println("It's 'X' turn");
		} else {
			System.out.printf("It's %s's turn. You're 'X'\n", name);
		}
		System.out.println("Please specify the row");
		int i = input.nextInt();
		System.out.println("Please specify the column");
		int j = input.nextInt();
		if(i > ROW || j > COL) {
			boardInput();
			throw new IndexOutOfBoundsException("\nPlease enter a number between 0 and 2");
		} else {
			if(board.equals(Character.isLetter('X')) || board.equals(Character.isLetter('O'))) {
				System.out.println("Sorry this spot is taken");
				boardInput();
			} else {
				board[i][j] = playerTurn;
				showBoard();
				playerTurnChange();
				isWin();
			}
		}
		return board;
	}

	public void isWin() {
		if((isDiagonalFull()) || (isRowFull()) || (isColumnFull())) {
			System.out.printf("You have won %s\n", name);
			System.out.println("Would you like a new Game?");
			String newGamePrompter = input.next();

			switch (newGamePrompter.toLowerCase().charAt(0)) {
				case 'y':
					winCheck = false;
					play();
					break;

				case 'n':
					if(name.isEmpty()) {
						System.out.println("Thanks for playing");
					} else {
						System.out.printf("Thanks for playing %s\n", name);
					}
					System.exit(0);
					break;

				default:
					System.out.println("Please answer with yes or no");
					isWin();
					break;
			}
		} else {
			winCheck = false;
			play();
		}
	}

	// CHECK: The next 3 methods checks if the board is full
	private boolean isRowFull() {
		if(board.equals(Character.isLetter('X')) || board.equals(Character.isLetter('O')) &&
				((board[0][0] == board[1][0] && board[0][0] == board[2][0]) ||
						(board[0][1] == board[1][1] && board[0][1] == board[2][1]) ||
						(board[0][2] == board[1][2] && board[0][2] == board[2][2]))) {
			winCheck = true;
		}
		return winCheck;
	}

	private boolean isColumnFull() {
		if(board.equals(Character.isLetter('X')) || board.equals(Character.isLetter('O')) &&
				((board[0][0] == board[0][1] && board[0][0] == board[0][2]) ||
						(board[1][0] == board[1][1] && board[1][0] == board[1][2]) ||
						(board[2][0] == board[2][1] && board[2][0] == board[2][2]))) {
			winCheck = true;
		}
		return winCheck;
	}

	private boolean isDiagonalFull() {
		if(board.equals(Character.isLetter('X')) || board.equals(Character.isLetter('O')) &&
				((board[0][0] == board[1][1] && board[0][0] == board[2][2]) ||
						(board[2][0] == board[1][1] && board[2][0] == board[0][2]))) {
			winCheck = true;
		}
		return winCheck;
	}
}
