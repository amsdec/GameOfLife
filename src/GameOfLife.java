/**
 * Created by alberto on 23/10/14.
 */
public class GameOfLife {

    public CellsGrid nextGeneration(CellsGrid grid) {
        CellsGrid newGeneration = new CellsGrid(grid.getRowCount(), grid.getColumnCount());
        for (int row = 0; row < grid.getRowCount(); row++) {
            for (int column = 0; column < grid.getColumnCount(); column++) {
                if (grid.isCellInPositionLive(row, column)) {
                    if (cellShouldDie(grid, row, column)) {
                        newGeneration.killCellInPosition(row, column);
                    } else {
                        newGeneration.giveLiveToCellInPosition(row, column);
                    }
                } else {
                    if (cellShouldBecomeLive(grid, row, column)) {
                        newGeneration.giveLiveToCellInPosition(row, column);
                    }
                }
            }
        }
        return newGeneration;
    }

    private boolean cellShouldBecomeLive(CellsGrid grid, int row, int column) {
        return NeighborFinder.howManyLiveNeighborsDoesTheCellHas(grid, row, column) == 3;
    }

    private boolean cellShouldDie(CellsGrid grid, int row, int column) {
        int liveNeighborsCountOfCell = NeighborFinder.howManyLiveNeighborsDoesTheCellHas(grid, row, column);
        return liveNeighborsCountOfCell < 2 || liveNeighborsCountOfCell > 3;
    }
}
