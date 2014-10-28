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
        giveLiveToCells(new int[][]{{0, 0}}, originalGrid);
        assertDeadGrid(game.nextGeneration(originalGrid));
    }

    @Test
    public void nextGenerationOfOneLiveCellWithOneLiveNeighborMustDie() {
        giveLiveToCells(new int[][]{{0, 0}, {0, 1}}, originalGrid);
        assertDeadGrid(game.nextGeneration(originalGrid));
    }

    @Test
    public void nextGenerationOfOneLiveCellWithTwoNeighborsMustLive() {
        giveLiveToCells(new int[][]{{0, 0}, {0, 1}, {1, 1}}, originalGrid);
        assertLiveSquare(game.nextGeneration(originalGrid));
    }

    @Test
    public void nextGenerationOfOneLiveCellWithThreeNeighborsMustLive() {
        giveLiveToCells(new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 0}}, originalGrid);
        assertLiveSquare(game.nextGeneration(originalGrid));
    }

    @Test
    public void nextGenerationOfOneDeadCellWithThreeLiveNeighborMustLive() {
        giveLiveToCells(new int[][]{{0, 1}, {1, 1}, {1, 0}}, originalGrid);
        assertLiveSquare(game.nextGeneration(originalGrid));
    }

    @Test
    public void toStringOfGridWithLiveCells() {
        giveLiveToCells(new int[][]{{1, 1}, {1, 2}, {2, 1}, {2, 2}}, originalGrid);
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

    @Test
    public void blockPattern() {
        giveLiveToCells(new int[][]{{1, 1}, {1, 2}, {2, 1}, {2, 2}}, originalGrid);
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
                        "          ", game.nextGeneration(originalGrid).toString());
    }


    @Test
    public void beeHivePattern() {
        giveLiveToCells(new int[][]{{1, 2}, {1, 3}, {2, 1}, {2, 4},{3, 2},{3, 3}}, originalGrid);
        Assert.assertEquals(
                "          \n" +
                "  XX      \n" +
                " X  X     \n" +
                "  XX      \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          ", game.nextGeneration(originalGrid).toString());
    }

    @Test
    public void loafPattern() {
        giveLiveToCells(new int[][]{{1, 2}, {1, 3}, {2, 1}, {2, 4},{3, 2},{3, 4},{4, 3}}, originalGrid);
        Assert.assertEquals(
                "          \n" +
                "  XX      \n" +
                " X  X     \n" +
                "  X X     \n" +
                "   X      \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          ", game.nextGeneration(originalGrid).toString());
    }

    @Test
    public void boatPattern() {
        giveLiveToCells(new int[][]{{1, 1}, {1, 2}, {2, 1}, {2, 3},{3, 2}}, originalGrid);
        Assert.assertEquals(
                "          \n" +
                " XX       \n" +
                " X X      \n" +
                "  X       \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          ", game.nextGeneration(originalGrid).toString());
    }

    @Test
    public void blinkerPattern() {
        giveLiveToCells(new int[][]{{2, 1}, {2, 2}, {2, 3}}, originalGrid);
        Assert.assertEquals(
                "          \n" +
                "  X       \n" +
                "  X       \n" +
                "  X       \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          ", game.nextGeneration(originalGrid).toString());
    }

    @Test
    public void toadPattern() {
        giveLiveToCells(new int[][]{{2, 2}, {2, 3}, {2, 4}, {3,1}, {3,2},{3,3}}, originalGrid);
        Assert.assertEquals(
                "          \n" +
                "   X      \n" +
                " X  X     \n" +
                " X  X     \n" +
                "  X       \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          ", game.nextGeneration(originalGrid).toString());
    }

    @Test
    public void beaconPattern() {
        giveLiveToCells(new int[][]{{1, 1}, {1, 2}, {2, 1}, {2,2}, {3,3},{3,4}, {4,3},{4,4}}, originalGrid);
        Assert.assertEquals(
                "          \n" +
                " XX       \n" +
                " X        \n" +
                "    X     \n" +
                "   XX     \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          \n" +
                "          ", game.nextGeneration(originalGrid).toString());
    }

    @Test
    public void pulsarPattern() {
        CellsGrid grid = new CellsGrid(17, 17);
        giveLiveToCells(new int[][]{
                {2, 4}, {2, 5}, {2, 6}, {2,10}, {2,11},{2,12},
                {4,2},{4,7}, {4,9},{4,14},
                {5,2},{5,7}, {5,9},{5,14},
                {6,2},{6,7}, {6,9},{6,14},
                {7, 4}, {7, 5}, {7, 6}, {7,10}, {7,11},{7,12},
                {9, 4}, {9, 5}, {9, 6}, {9,10}, {9,11},{9,12},
                {10,2},{10,7}, {10,9},{10,14},
                {11,2},{11,7}, {11,9},{11,14},
                {12,2},{12,7}, {12,9},{12,14},
                {14, 4}, {14, 5}, {14, 6}, {14,10}, {14,11},{14,12},
        }, grid);
        grid = game.nextGeneration(grid);
        Assert.assertEquals(
                "                 \n" +
                "     X     X     \n" +
                "     X     X     \n" +
                "     XX   XX     \n" +
                "                 \n" +
                " XXX  XX XX  XXX \n" +
                "   X X X X X X   \n" +
                "     XX   XX     \n" +
                "                 \n" +
                "     XX   XX     \n" +
                "   X X X X X X   \n" +
                " XXX  XX XX  XXX \n" +
                "                 \n" +
                "     XX   XX     \n" +
                "     X     X     \n" +
                "     X     X     \n" +
                "                 ", grid.toString());
        grid = game.nextGeneration(grid);
        Assert.assertEquals(
                "                 \n" +
                "                 \n" +
                "    XX     XX    \n" +
                "     XX   XX     \n" +
                "  X  X X X X  X  \n" +
                "  XXX XX XX XXX  \n" +
                "   X X X X X X   \n" +
                "    XXX   XXX    \n" +
                "                 \n" +
                "    XXX   XXX    \n" +
                "   X X X X X X   \n" +
                "  XXX XX XX XXX  \n" +
                "  X  X X X X  X  \n" +
                "     XX   XX     \n" +
                "    XX     XX    \n" +
                "                 \n" +
                "                 ", grid.toString());
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

    private void giveLiveToCells(int[][] cells, CellsGrid originalGrid1) {
        for (int[] cell : cells) {
            originalGrid1.giveLiveToCellInPosition(cell[0], cell[1]);
        }
    }
}