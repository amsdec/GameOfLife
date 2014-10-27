import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by alberto on 23/10/14.
 */
public class GameOfLifeTest {
    private GameOfLife game;
    private CellsGrid originalGrid;

    @Before
    public void setup() {
        game = new GameOfLife();
        originalGrid = createCellsGrid();
    }

    @Test
    public void nextGenerationOfOneLiveCellWithoutNeighborsMustDie() {
        giveLiveToCells(new int[][]{{0, 0}});
        assertDeadGrid(game.nextGeneration(originalGrid));
    }

    @Test
    public void nextGenerationOfOneLiveCellWithOneLiveNeighborMustDie() {
        giveLiveToCells(new int[][]{{0, 0}, {0, 1}});
        assertDeadGrid(game.nextGeneration(originalGrid));
    }

    @Test
    public void nextGenerationOfOneLiveCellWithTwoNeighborsMustLive() {
        giveLiveToCells(new int[][]{{0, 0}, {0, 1}, {1, 1}});
        assertLiveSquare(game.nextGeneration(originalGrid));
    }

    @Test
    public void nextGenerationOfOneLiveCellWithThreeNeighborsMustLive() {
        giveLiveToCells(new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 0}});
        assertLiveSquare(game.nextGeneration(originalGrid));
    }

    @Test
    public void nextGenerationOfOneDeadCellWithThreeLiveNeighborMustLive() {
        giveLiveToCells(new int[][]{{0, 1}, {1, 1}, {1, 0}});
        assertLiveSquare(game.nextGeneration(originalGrid));
    }

    @Test
    public void toStringOfGrid() {
        Assert.assertEquals(
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          ", originalGrid.toString());
    }

    @Test
    public void toStringOfGridWithLiveCells() {
        giveLiveToCells(new int[][]{{1, 1}, {1, 2}, {2, 1}, {2, 2}});
        Assert.assertEquals(
                "          \n" +
                        " XX       \n" +
                        " XX       \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "          ", originalGrid.toString());
    }

    private void assertThatTheSizeOfTheGridsAreTheSame(CellsGrid nextGeneration) {
        Assert.assertEquals(originalGrid.getRowCount(), nextGeneration.getRowCount());
        Assert.assertEquals(originalGrid.getColumnCount(), nextGeneration.getColumnCount());
    }

    private void assertThatCellIsLive(CellsGrid grid, int row, int column) {
        Assert.assertTrue("Cell in " + row + ", " + column + " must be live", grid.isCellInPositionLive(row, column));
    }

    private void assertDeadGrid(CellsGrid nextGeneration) {
        assertThatTheSizeOfTheGridsAreTheSame(nextGeneration);
        for (int row = 0; row < nextGeneration.getRowCount(); row++) {
            for (int column = 0; column < nextGeneration.getColumnCount(); column++) {
                assertThatCellIsDead(nextGeneration, row, column);
            }
        }
    }

    private void assertLiveSquare(CellsGrid nextGeneration) {
        assertThatTheSizeOfTheGridsAreTheSame(nextGeneration);
        for (int row = 0; row < nextGeneration.getRowCount(); row++) {
            for (int column = 0; column < nextGeneration.getColumnCount(); column++) {
                if (row == 0 && column == 0) {
                    assertThatCellIsLive(nextGeneration, row, column);
                } else if (row == 0 && column == 1) {
                    assertThatCellIsLive(nextGeneration, row, column);
                } else if (row == 1 && column == 1) {
                    assertThatCellIsLive(nextGeneration, row, column);
                } else if (row == 1 && column == 0) {
                    assertThatCellIsLive(nextGeneration, row, column);
                } else assertThatCellIsDead(nextGeneration, row, column);
            }
        }
    }

    private CellsGrid createCellsGrid() {
        return new CellsGrid(10, 10);
    }

    private void assertThatCellIsDead(CellsGrid grid, int row, int column) {
        Assert.assertFalse("next generation of " + row + ", " + column + " must be dead", grid.isCellInPositionLive(row, column));
    }

    private void giveLiveToCells(int[][] cells) {
        for (int[] cell : cells) {
            originalGrid.giveLiveToCellInPosition(cell[0], cell[1]);
        }
    }
}