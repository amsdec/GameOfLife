/**
 * Created by alberto on 23/10/14.
 */
public class GameOfLife {

    public Cell[][] nextGeneration(Cell[][] grid) {
        for (int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid.length; column++) {
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

    private void giveLiveToCell(Cell[][] grid, int row, int column) {
        grid[row][column].giveLive();
    }

    private boolean cellShouldBecomeLive(Cell[][] grid, int row, int column) {
        return howManyLiveNeighborsTheCellHas(grid, row, column) == 3;
    }

    private void killCell(Cell[][] grid, int row, int column) {
        grid[row][column].kill();
    }

    private boolean cellShouldDie(Cell[][] grid, int row, int column) {
        int liveNeighborsCountOfCell = howManyLiveNeighborsTheCellHas(grid, row, column);
        return liveNeighborsCountOfCell < 2 || liveNeighborsCountOfCell > 3;
    }

    private int howManyLiveNeighborsTheCellHas(Cell[][] grid, int row, int column) {
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

    private boolean isLowerRightNeighborLive(Cell[][] grid, int row, int column) {
        return isCellLive(grid, row + 1, column + 1);
    }

    private boolean isRightNeighborLive(Cell[][] grid, int row, int column) {
        return isCellLive(grid, row, column+1);
    }

    private boolean isUpperRightNeighborLive(Cell[][] grid, int row, int column) {
        return isCellLive(grid, row - 1, column + 1);
    }

    private boolean isLowerNeighborLive(Cell[][] grid, int row, int column) {
        return isCellLive(grid, row+1, column);
    }

    private boolean isUpperNeighborLive(Cell[][] grid, int row, int column) {
        return isCellLive(grid, row-1, column);
    }

    private boolean isLowerLeftNeighborLive(Cell[][] grid, int row, int column) {
        return isCellLive(grid, row + 1, column - 1);
    }

    private boolean isLeftNeighborLive(Cell[][] grid, int row, int column) {
        return isCellLive(grid, row, column-1);
    }

    private boolean isUpperLeftNeighborLive(Cell[][] grid, int row, int column) {
        return isCellLive(grid, row - 1, column - 1);
    }

    private boolean isThereALowerRightNeighbor(Cell[][] grid, int row, int column) {
        return row + 1 < grid.length && column + 1 < grid.length;
    }

    private boolean isThereARightNeighbor(Cell[][] grid, int column) {
        return column +1 < grid.length;
    }

    private boolean isThereAnUpperRightNeighbor(Cell[][] grid, int row, int column) {
        return row - 1 > -1 && column + 1 < grid.length;
    }

    private boolean isThereALowerNeighbor(Cell[][] grid, int row) {
        return row +1 < grid.length;
    }

    private boolean isThereAnUpperNeighbor(int row) {
        return row -1 > -1;
    }

    private boolean isThereALowerLeftNeighbor(Cell[][] grid, int row, int column) {
        return row + 1 < grid.length && column - 1 > -1;
    }

    private boolean isThereALeftNeighbor(int column) {
        return column -1 > -1;
    }

    private boolean isThereAnUpperLeftNeighbor(int row, int column) {
        return row - 1 > -1 && column - 1 > -1;
    }

    private boolean isCellLive(Cell[][] grid, int row, int column) {
        return grid[row][column].isLive();
    }
}
