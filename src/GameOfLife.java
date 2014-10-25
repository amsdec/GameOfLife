/**
 * Created by alberto on 23/10/14.
 */
public class GameOfLife {

    public String[][] nextGeneration(String[][] grid) {
        for (int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid.length; column++) {
                if(isCellLive(grid, row, column)) {
                    if(cellShouldDie(grid, row, column)) {
                        killCell(grid, row, column);
                    }
                }
            }
        }
        return grid;
    }

    private void killCell(String[][] grid, int row, int column) {
        grid[row][column] = null;
    }

    private boolean cellShouldDie(String[][] grid, int row, int column) {
        return getLiveNeighborsCountOfCell(grid, row, column) != 2;
    }

    private int getLiveNeighborsCountOfCell(String[][] grid, int row, int column) {
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

    private boolean isLowerRightNeighborLive(String[][] grid, int row, int column) {
        return isCellLive(grid, row + 1, column + 1);
    }

    private boolean isRightNeighborLive(String[][] grid, int row, int column) {
        return isCellLive(grid, row, column+1);
    }

    private boolean isUpperRightNeighborLive(String[][] grid, int row, int column) {
        return isCellLive(grid, row - 1, column + 1);
    }

    private boolean isLowerNeighborLive(String[][] grid, int row, int column) {
        return isCellLive(grid, row+1, column);
    }

    private boolean isUpperNeighborLive(String[][] grid, int row, int column) {
        return isCellLive(grid, row-1, column);
    }

    private boolean isLowerLeftNeighborLive(String[][] grid, int row, int column) {
        return isCellLive(grid, row + 1, column - 1);
    }

    private boolean isLeftNeighborLive(String[][] grid, int row, int column) {
        return isCellLive(grid, row, column-1);
    }

    private boolean isUpperLeftNeighborLive(String[][] grid, int row, int column) {
        return isCellLive(grid, row - 1, column - 1);
    }

    private boolean isThereALowerRightNeighbor(String[][] grid, int row, int column) {
        return row + 1 < grid.length && column + 1 < grid.length;
    }

    private boolean isThereARightNeighbor(String[][] grid, int column) {
        return column +1 < grid.length;
    }

    private boolean isThereAnUpperRightNeighbor(String[][] grid, int row, int column) {
        return row - 1 > -1 && column + 1 < grid.length;
    }

    private boolean isThereALowerNeighbor(String[][] grid, int row) {
        return row +1 < grid.length;
    }

    private boolean isThereAnUpperNeighbor(int row) {
        return row -1 > -1;
    }

    private boolean isThereALowerLeftNeighbor(String[][] grid, int row, int column) {
        return row + 1 < grid.length && column - 1 > -1;
    }

    private boolean isThereALeftNeighbor(int column) {
        return column -1 > -1;
    }

    private boolean isThereAnUpperLeftNeighbor(int row, int column) {
        return row - 1 > -1 && column - 1 > -1;
    }

    private boolean isCellLive(String[][] grid, int row, int column) {
        return grid[row][column] != null;
    }
}
