import org.junit.Before;
import org.junit.Test;

/**
 * Created by alberto on 23/10/14.
 */
public class GameOfLifeTest {
    private GameOfLife game;

    @Before
    public void setup() {
        game = new GameOfLife();
    }

    @Test
    public void canCalculateNextGeneration() {
        game.nextGeneration();
    }
}
