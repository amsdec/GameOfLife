/**
 * Created by alberto on 23/10/14.
 */
public class GameOfLife {

    public CellsGrid nextGeneration(CellsGrid grid) {
        for (int row = 0; row < grid.getRowCount(); row++){
            for(int column = 0; column < grid.getColumnCount(); column++) {
                if(isCellLive(grid, row, column)) {
                    if(cellShouldDie(grid, row, column)) {
                        killCell(grid, row, column);
                    }
                } else {
                    if(cellShouldBecomeLive(grid, row, column)) {
                        giveLiveToCell(grid, row, column);
                    }
                }
            }
        }
        return grid;
    }

    private void giveLiveToCell(CellsGrid grid, int row, int column) {
        grid.getCellInPosition(row, column).giveLive();
    }

    private boolean cellShouldBecomeLive(CellsGrid grid, int row, int column) {
        return howManyLiveNeighborsTheCellHas(grid, row, column) == 3;
    }

    private void killCell(CellsGrid grid, int row, int column) {
        grid.getCellInPosition(row, column).kill();
    }

    private boolean cellShouldDie(CellsGrid grid, int row, int column) {
        int liveNeighborsCountOfCell = howManyLiveNeighborsTheCellHas(grid, row, column);
        return liveNeighborsCountOfCell < 2 || liveNeighborsCountOfCell > 3;
    }

    private int howManyLiveNeighborsTheCellHas(CellsGrid grid, int row, int column) {
        int liveNeighbors = 0;
        if(isThereAnUpperLeftNeighbor(row, column) && isUpperLeftNeighborLive(grid, row, column)){
            liveNeighbors++;
        }
        if(isThereALeftNeighbor(column) && isLeftNeighborLive(grid, row, column)){
            liveNeighbors++;
        }
        if(isThereALowerLeftNeighbor(grid, row, column) && isLowerLeftNeighborLive(grid, row, column)){
            liveNeighbors++;
        }
        if(isThereAnUpperNeighbor(row) && isUpperNeighborLive(grid, row, column)){
            liveNeighbors++;
        }
        if(isThereALowerNeighbor(grid, row) && isLowerNeighborLive(grid, row, column)){
            liveNeighbors++;
        }
        if(isThereAnUpperRightNeighbor(grid, row, column) && isUpperRightNeighborLive(grid, row, column)){
            liveNeighbors++;
        }
        if(isThereARightNeighbor(grid, column) && isRightNeighborLive(grid, row, column)){
            liveNeighbors++;
        }
        if(isThereALowerRightNeighbor(grid, row, column) && isLowerRightNeighborLive(grid, row, column)){
            liveNeighbors++;
        }
        return liveNeighbors;
    }

    private boolean isLowerRightNeighborLive(CellsGrid grid, int row, int column) {
        return isCellLive(grid, row + 1, column + 1);
    }

    private boolean isRightNeighborLive(CellsGrid grid, int row, int column) {
        return isCellLive(grid, row, column+1);
    }

    private boolean isUpperRightNeighborLive(CellsGrid grid, int row, int column) {
        return isCellLive(grid, row - 1, column + 1);
    }

    private boolean isLowerNeighborLive(CellsGrid grid, int row, int column) {
        return isCellLive(grid, row+1, column);
    }

    private boolean isUpperNeighborLive(CellsGrid grid, int row, int column) {
        return isCellLive(grid, row-1, column);
    }

    private boolean isLowerLeftNeighborLive(CellsGrid grid, int row, int column) {
        return isCellLive(grid, row + 1, column - 1);
    }

    private boolean isLeftNeighborLive(CellsGrid grid, int row, int column) {
        return isCellLive(grid, row, column-1);
    }

    private boolean isUpperLeftNeighborLive(CellsGrid grid, int row, int column) {
        return isCellLive(grid, row - 1, column - 1);
    }

    private boolean isThereALowerRightNeighbor(CellsGrid grid, int row, int column) {
        return row + 1 < grid.getRowCount() && column + 1 < grid.getColumnCount();
    }

    private boolean isThereARightNeighbor(CellsGrid grid, int column) {
        return column +1 < grid.getColumnCount();
    }

    private boolean isThereAnUpperRightNeighbor(CellsGrid grid, int row, int column) {
        return row - 1 > -1 && column + 1 < grid.getColumnCount();
    }

    private boolean isThereALowerNeighbor(CellsGrid grid, int row) {
        return row +1 < grid.getRowCount();
    }

    private boolean isThereAnUpperNeighbor(int row) {
        return row -1 > -1;
    }

    private boolean isThereALowerLeftNeighbor(CellsGrid grid, int row, int column) {
        return row + 1 < grid.getRowCount() && column - 1 > -1;
    }

    private boolean isThereALeftNeighbor(int column) {
        return column -1 > -1;
    }

    private boolean isThereAnUpperLeftNeighbor(int row, int column) {
        return row - 1 > -1 && column - 1 > -1;
    }

    private boolean isCellLive(CellsGrid grid, int row, int column) {
        return grid.getCellInPosition(row, column).isLive();
    }
}
