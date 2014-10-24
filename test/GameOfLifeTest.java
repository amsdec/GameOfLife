import org.junit.Test;

/**
 * Created by alberto on 23/10/14.
 */
public class GameOfLifeTest {
    @Test
    public void nothing(){

    }

    @Test
    public void canStartGame() {
        GameOfLife game = new GameOfLife();
    }

    @Test
    public void canCalculateNextGeneration() {
        GameOfLife game = new GameOfLife();
        game.nextGeneration();
    }
}
