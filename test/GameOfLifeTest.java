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
        Cell[][] originalGrid = createCellsGrid();
        giveLiveToCell(originalGrid, 0, 0);
        Cell[][] nextGeneration = game.nextGeneration(originalGrid);
        Assert.assertArrayEquals(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.length; row++){
            for(int column = 0; column < nextGeneration.length; column++) {
                assertThatCellIsDead(nextGeneration, row, column);
            }
        }
    }

    private Cell[][] createCellsGrid() {
        Cell[][] grid = new Cell[10][10];
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid.length; column++){
                grid[row][column] = new Cell(false);
            }
        }
        return grid;
    }

    @Test
    public void nextGenerationOfOneLiveCellWithTwoNeighborsMustLive() {
        Cell[][] originalGrid = createCellsGrid();
        giveLiveToCell(originalGrid, 0, 0);
        giveLiveToCell(originalGrid, 0, 1);
        giveLiveToCell(originalGrid, 1, 1);
        Cell[][] nextGeneration = game.nextGeneration(originalGrid);
        Assert.assertArrayEquals(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.length; row++){
            for(int column = 0; column < nextGeneration.length; column++) {
                if(row == 0 && column == 0){
                    assertThatCellIsLive(nextGeneration, row, column);
                } else if(row == 0 && column == 1){
                    assertThatCellIsLive(nextGeneration, row, column);
                }else if(row == 1 && column == 1){
                    assertThatCellIsLive(nextGeneration, row, column);
                }else if(row == 1 && column == 0) {
                    assertThatCellIsLive(nextGeneration, row, column);
                } else assertThatCellIsDead(nextGeneration, row, column);
            }
        }
    }

    private void assertThatCellIsDead(Cell[][] grid, int row, int column) {
        Assert.assertFalse("next generation of " + row + ", " + column + " must be dead", grid[row][column].isLive());
    }

    @Test
    public void nextGenerationOfOneLiveCellWithThreeNeighborsMustLive() {
        Cell[][] originalGrid = createCellsGrid();
        giveLiveToCell(originalGrid, 0, 0);
        giveLiveToCell(originalGrid, 0, 1);
        giveLiveToCell(originalGrid, 1, 1);
        giveLiveToCell(originalGrid, 1, 0);
        Cell[][] nextGeneration = game.nextGeneration(originalGrid);
        Assert.assertArrayEquals(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.length; row++){
            for(int column = 0; column < nextGeneration.length; column++) {
                if(row == 0 && column == 0){
                    assertThatCellIsLive(nextGeneration, row, column);
                } else if(row == 0 && column == 1){
                    assertThatCellIsLive(nextGeneration, row, column);
                }else if(row == 1 && column == 1){
                    assertThatCellIsLive(nextGeneration, row, column);
                }else if(row == 1 && column == 0) {
                    assertThatCellIsLive(nextGeneration, row, column);
                } else assertThatCellIsDead(nextGeneration, row, column);
            }
        }
    }

    @Test
    public void nextGenerationOfOneLiveCellWithOneLiveNeighborMustDie() {
        Cell[][] originalGrid = createCellsGrid();
        giveLiveToCell(originalGrid, 0, 0);
        giveLiveToCell(originalGrid, 0, 1);
        Cell[][] nextGeneration = game.nextGeneration(originalGrid);
        Assert.assertArrayEquals(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.length; row++){
            for(int column = 0; column < nextGeneration.length; column++) {
                assertThatCellIsDead(nextGeneration, row, column);
            }
        }
    }

    @Test
    public void nextGenerationOfOneDeadCellWithThreeLiveNeighborMustLive() {
        Cell[][] originalGrid = createCellsGrid();
        giveLiveToCell(originalGrid, 0, 1);
        giveLiveToCell(originalGrid, 1, 1);
        giveLiveToCell(originalGrid, 1, 0);
        Cell[][] nextGeneration = game.nextGeneration(originalGrid);
        Assert.assertArrayEquals(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.length; row++){
            for(int column = 0; column < nextGeneration.length; column++) {
                if(row == 0 && column == 0){
                    assertThatCellIsLive(nextGeneration, row, column);
                } else if(row == 0 && column == 1){
                    assertThatCellIsLive(nextGeneration, row, column);
                }else if(row == 1 && column == 1){
                    assertThatCellIsLive(nextGeneration, row, column);
                }else if(row == 1 && column == 0) {
                    assertThatCellIsLive(nextGeneration, row, column);
                } else assertThatCellIsDead(nextGeneration, row, column);
            }
        }
    }

    private void assertThatCellIsLive(Cell[][] grid, int row, int column){
        Assert.assertTrue("Cell in " + row + ", " + column + " must be live", grid[row][column].isLive());
    }

    private void giveLiveToCell(Cell[][] originalGrid, int row, int column) {
        originalGrid[row][column].giveLive();
    }
}
