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
    public void nextGenerationAlwaysMustReturnAGridWithSameSize() {
        String[][] originalGrid = new String[10][10];
        String[][] nextGeneration = game.nextGeneration(originalGrid);
        Assert.assertNotNull(nextGeneration);
        Assert.assertArrayEquals(originalGrid, nextGeneration);
    }

    @Test
    public void nextGenerationOfOneLiveCellWithoutNeighborsMustDie() {
        String[][] originalGrid = new String[10][10];
        originalGrid[0][0] = "X";
        String[][] nextGeneration = game.nextGeneration(originalGrid);
        Assert.assertNotNull(nextGeneration);
        Assert.assertArrayEquals(originalGrid, nextGeneration);
        for(String[] row: nextGeneration) {
            for(String column: row) {
                Assert.assertNull(column);
            }
        }
    }
}
