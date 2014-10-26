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
        CellsGrid originalGrid = createCellsGrid();
        giveLiveToCell(originalGrid, 0, 0);
        CellsGrid nextGeneration = game.nextGeneration(originalGrid);
        assertThatTheSizeOfTheGridsAreTheSame(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.getRowCount(); row++){
            for(int column = 0; column < nextGeneration.getColumnCount(); column++) {
                assertThatCellIsDead(nextGeneration, row, column);
            }
        }
    }

    private CellsGrid createCellsGrid() {
        return new CellsGrid(10, 10);
    }

    @Test
    public void nextGenerationOfOneLiveCellWithTwoNeighborsMustLive() {
        CellsGrid originalGrid = createCellsGrid();
        giveLiveToCell(originalGrid, 0, 0);
        giveLiveToCell(originalGrid, 0, 1);
        giveLiveToCell(originalGrid, 1, 1);
        CellsGrid nextGeneration = game.nextGeneration(originalGrid);
        assertThatTheSizeOfTheGridsAreTheSame(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.getRowCount(); row++){
            for(int column = 0; column < nextGeneration.getColumnCount(); column++) {
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

    private void assertThatCellIsDead(CellsGrid grid, int row, int column) {
        Assert.assertFalse("next generation of " + row + ", " + column + " must be dead", grid.isCellInPositionLive(row, column));
    }

    @Test
    public void nextGenerationOfOneLiveCellWithThreeNeighborsMustLive() {
        CellsGrid originalGrid = createCellsGrid();
        giveLiveToCell(originalGrid, 0, 0);
        giveLiveToCell(originalGrid, 0, 1);
        giveLiveToCell(originalGrid, 1, 1);
        giveLiveToCell(originalGrid, 1, 0);
        CellsGrid nextGeneration = game.nextGeneration(originalGrid);
        assertThatTheSizeOfTheGridsAreTheSame(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.getRowCount(); row++){
            for(int column = 0; column < nextGeneration.getColumnCount(); column++) {
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
        CellsGrid originalGrid = createCellsGrid();
        giveLiveToCell(originalGrid, 0, 0);
        giveLiveToCell(originalGrid, 0, 1);
        CellsGrid nextGeneration = game.nextGeneration(originalGrid);
        assertThatTheSizeOfTheGridsAreTheSame(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.getRowCount(); row++){
            for(int column = 0; column < nextGeneration.getColumnCount(); column++) {
                assertThatCellIsDead(nextGeneration, row, column);
            }
        }
    }

    @Test
    public void nextGenerationOfOneDeadCellWithThreeLiveNeighborMustLive() {
        CellsGrid originalGrid = createCellsGrid();
        giveLiveToCell(originalGrid, 0, 1);
        giveLiveToCell(originalGrid, 1, 1);
        giveLiveToCell(originalGrid, 1, 0);
        CellsGrid nextGeneration = game.nextGeneration(originalGrid);
        assertThatTheSizeOfTheGridsAreTheSame(originalGrid, nextGeneration);
        for (int row = 0; row < nextGeneration.getRowCount(); row++){
            for(int column = 0; column < nextGeneration.getColumnCount(); column++) {
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

    private void assertThatTheSizeOfTheGridsAreTheSame(CellsGrid originalGrid, CellsGrid nextGeneration) {
        Assert.assertEquals(originalGrid.getRowCount(), nextGeneration.getRowCount());
        Assert.assertEquals(originalGrid.getColumnCount(), nextGeneration.getColumnCount());
    }

    private void assertThatCellIsLive(CellsGrid grid, int row, int column){
        Assert.assertTrue("Cell in " + row + ", " + column + " must be live", grid.isCellInPositionLive(row, column));
    }

    private void giveLiveToCell(CellsGrid originalGrid, int row, int column) {
        originalGrid.giveLiveToCellInPosition(row, column);
    }
}
