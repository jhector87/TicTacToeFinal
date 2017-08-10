/**
 * @author jonathanhector on 27.02.17.
 */
public class TicTacToe {

	public static void main(String[] args) {
		String name = "";
		Prompter prompt = new Prompter(name);
		Game game = new Game(prompt);
		game.play();
	}
}
