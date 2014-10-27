/**
 * Created by alberto on 26/10/14.
 */
public class NeighborFinder {

    public static int howManyLiveNeighborsDoesTheCellHas(CellsGrid grid, int row, int column) {
        int liveNeighbors = 0;
        if (isThereAnUpperLeftNeighbor(row, column) && isUpperLeftNeighborLive(grid, row, column)) {
            liveNeighbors++;
        }
        if (isThereALeftNeighbor(column) && isLeftNeighborLive(grid, row, column)) {
            liveNeighbors++;
        }
        if (isThereALowerLeftNeighbor(grid, row, column) && isLowerLeftNeighborLive(grid, row, column)) {
            liveNeighbors++;
        }
        if (isThereAnUpperNeighbor(row) && isUpperNeighborLive(grid, row, column)) {
            liveNeighbors++;
        }
        if (isThereALowerNeighbor(grid, row) && isLowerNeighborLive(grid, row, column)) {
            liveNeighbors++;
        }
        if (isThereAnUpperRightNeighbor(grid, row, column) && isUpperRightNeighborLive(grid, row, column)) {
            liveNeighbors++;
        }
        if (isThereARightNeighbor(grid, column) && isRightNeighborLive(grid, row, column)) {
            liveNeighbors++;
        }
        if (isThereALowerRightNeighbor(grid, row, column) && isLowerRightNeighborLive(grid, row, column)) {
            liveNeighbors++;
        }
        return liveNeighbors;
    }

    private static boolean isLowerRightNeighborLive(CellsGrid grid, int row, int column) {
        return grid.isCellInPositionLive(row + 1, column + 1);
    }

    private static boolean isRightNeighborLive(CellsGrid grid, int row, int column) {
        return grid.isCellInPositionLive(row, column + 1);
    }

    private static boolean isUpperRightNeighborLive(CellsGrid grid, int row, int column) {
        return grid.isCellInPositionLive(row - 1, column + 1);
    }

    private static boolean isLowerNeighborLive(CellsGrid grid, int row, int column) {
        return grid.isCellInPositionLive(row + 1, column);
    }

    private static boolean isUpperNeighborLive(CellsGrid grid, int row, int column) {
        return grid.isCellInPositionLive(row - 1, column);
    }

    private static boolean isLowerLeftNeighborLive(CellsGrid grid, int row, int column) {
        return grid.isCellInPositionLive(row + 1, column - 1);
    }

    private static boolean isLeftNeighborLive(CellsGrid grid, int row, int column) {
        return grid.isCellInPositionLive(row, column - 1);
    }

    private static boolean isUpperLeftNeighborLive(CellsGrid grid, int row, int column) {
        return grid.isCellInPositionLive(row - 1, column - 1);
    }

    private static boolean isThereALowerRightNeighbor(CellsGrid grid, int row, int column) {
        return row + 1 < grid.getRowCount() && column + 1 < grid.getColumnCount();
    }

    private static boolean isThereARightNeighbor(CellsGrid grid, int column) {
        return column + 1 < grid.getColumnCount();
    }

    private static boolean isThereAnUpperRightNeighbor(CellsGrid grid, int row, int column) {
        return row - 1 > -1 && column + 1 < grid.getColumnCount();
    }

    private static boolean isThereALowerNeighbor(CellsGrid grid, int row) {
        return row + 1 < grid.getRowCount();
    }

    private static boolean isThereAnUpperNeighbor(int row) {
        return row - 1 > -1;
    }

    private static boolean isThereALowerLeftNeighbor(CellsGrid grid, int row, int column) {
        return row + 1 < grid.getRowCount() && column - 1 > -1;
    }

    private static boolean isThereALeftNeighbor(int column) {
        return column - 1 > -1;
    }

    private static boolean isThereAnUpperLeftNeighbor(int row, int column) {
        return row - 1 > -1 && column - 1 > -1;
    }

}
