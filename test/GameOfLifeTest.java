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
    public void nextGenerationOfOneLiveCellWithoutNeighborsMustDie() {
        String[][] originalGrid = new String[10][10];
        originalGrid[0][0] = "X";
        String[][] nextGeneration = game.nextGeneration(originalGrid);
        Assert.assertArrayEquals(originalGrid, nextGeneration);
        for(String[] row: nextGeneration) {
            for(String column: row) {
                Assert.assertNull(column);
            }
        }
    }

    @Test
    public void nextGenerationOfOneLiveCellWithTwoNeighborsMustLive() {
        String[][] originalGrid = new String[10][10];
        originalGrid[0][0] = "X";
        originalGrid[0][1] = "X";
        originalGrid[1][1] = "X";
        String[][] nextGeneration = game.nextGeneration(originalGrid);
        Assert.assertArrayEquals(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.length; row++){
            for(int column = 0; column < nextGeneration.length; column++) {
                if(row == 0 && column == 0){
                    Assert.assertEquals("X",nextGeneration[row][column]);
                }
                if(row == 0 && column == 1){
                    Assert.assertEquals("X",nextGeneration[row][column]);
                }
                if(row == 1 && column == 1){
                    Assert.assertEquals("X",nextGeneration[row][column]);
                }
                Assert.assertNull(nextGeneration[row][column]);
            }
        }
    }
}
