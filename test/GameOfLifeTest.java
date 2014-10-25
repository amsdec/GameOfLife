import org.junit.Assert;
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
    public void nextGenerationAllwaysMustRetunAGrid() {
        Assert.assertNotNull(game.nextGeneration(new String[10][10]));
    }

    @Test
    public void nextGenerationAlwaysMustReturnAGridWithSameSize() {
        String[][] nextGeneration = game.nextGeneration(new String[10][10]);
        Assert.assertNotNull(nextGeneration);
        Assert.assertArrayEquals(new String[10][10], nextGeneration);
    }
}
