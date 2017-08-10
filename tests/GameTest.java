import org.junit.Before;
import org.junit.Test;

/**
 * @author jonathanhector on 02.03.17.
 */
public class GameTest {
	Game game;
	Prompter prompt;

	@Before
	public void setUp() throws Exception {
		prompt = new Prompter("Jonathan");
		game = new Game(prompt);
	}

	@Test
	public void playTheGameAndSeeWhatAreTheResults() throws Exception {
		game.play();
	}

	@Test
	public void checkIfThePlayerWonOrLoss(){
		game.isWin();
	}
}