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
        giveLiveToCell(originalGrid, 0, 0);
        String[][] nextGeneration = game.nextGeneration(originalGrid);
        Assert.assertArrayEquals(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.length; row++){
            for(int column = 0; column < nextGeneration.length; column++) {
                Assert.assertNull(nextGeneration[row][column]);
            }
        }
    }

    @Test
    public void nextGenerationOfOneLiveCellWithTwoNeighborsMustLive() {
        String[][] originalGrid = new String[10][10];
        giveLiveToCell(originalGrid, 0, 0);
        giveLiveToCell(originalGrid, 0, 1);
        giveLiveToCell(originalGrid, 1, 1);
        String[][] nextGeneration = game.nextGeneration(originalGrid);
        Assert.assertArrayEquals(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.length; row++){
            for(int column = 0; column < nextGeneration.length; column++) {
                if(row == 0 && column == 0){
                    Assert.assertEquals("X",nextGeneration[row][column]);
                } else if(row == 0 && column == 1){
                    Assert.assertEquals("X",nextGeneration[row][column]);
                }else if(row == 1 && column == 1){
                    Assert.assertEquals("X",nextGeneration[row][column]);
                }else Assert.assertNull(nextGeneration[row][column]);
            }
        }
    }

    @Test
    public void nextGenerationOfOneLiveCellWithThreeNeighborsMustLive() {
        String[][] originalGrid = new String[10][10];
        giveLiveToCell(originalGrid, 0, 0);
        giveLiveToCell(originalGrid, 0, 1);
        giveLiveToCell(originalGrid, 1, 1);
        giveLiveToCell(originalGrid, 1, 0);
        String[][] nextGeneration = game.nextGeneration(originalGrid);
        Assert.assertArrayEquals(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.length; row++){
            for(int column = 0; column < nextGeneration.length; column++) {
                if(row == 0 && column == 0){
                    Assert.assertEquals("X",nextGeneration[row][column]);
                } else if(row == 0 && column == 1){
                    Assert.assertEquals("X",nextGeneration[row][column]);
                }else if(row == 1 && column == 1){
                    Assert.assertEquals("X",nextGeneration[row][column]);
                }else if(row == 1 && column == 0) {
                    Assert.assertEquals("X",nextGeneration[row][column]);
                } else Assert.assertNull(nextGeneration[row][column]);
            }
        }
    }

    @Test
    public void nextGenerationOfOneLiveCellWithOneLiveNeighborMustDie() {
        String[][] originalGrid = new String[10][10];
        giveLiveToCell(originalGrid, 0, 0);
        giveLiveToCell(originalGrid, 0, 1);
        String[][] nextGeneration = game.nextGeneration(originalGrid);
        Assert.assertArrayEquals(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.length; row++){
            for(int column = 0; column < nextGeneration.length; column++) {
                Assert.assertNull(nextGeneration[row][column]);
            }
        }
    }

    private void giveLiveToCell(String[][] originalGrid, int row, int column) {
        originalGrid[row][column] = "X";
    }
}
