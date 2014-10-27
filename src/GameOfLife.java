/**
 * Created by alberto on 23/10/14.
 */
public class GameOfLife {

    public CellsGrid nextGeneration(CellsGrid grid) {
        for (int row = 0; row < grid.getRowCount(); row++) {
            for (int column = 0; column < grid.getColumnCount(); column++) {
                if (grid.isCellInPositionLive(row, column)) {
                    if (cellShouldDie(grid, row, column)) {
                        grid.killCellInPosition(row, column);
                    }
                } else {
                    if (cellShouldBecomeLive(grid, row, column)) {
                        grid.giveLiveToCellInPosition(row, column);
                    }
                }
            }
        }
        return grid;
    }

    private boolean cellShouldBecomeLive(CellsGrid grid, int row, int column) {
        return NeighborFinder.howManyLiveNeighborsDoesTheCellHas(grid, row, column) == 3;
    }

    private boolean cellShouldDie(CellsGrid grid, int row, int column) {
        int liveNeighborsCountOfCell = NeighborFinder.howManyLiveNeighborsDoesTheCellHas(grid, row, column);
        return liveNeighborsCountOfCell < 2 || liveNeighborsCountOfCell > 3;
    }
}
