/**
 * Created by alberto on 26/10/14.
 */
public class CellsGrid {
    private int rows;
    private int columns;
    private Cell[][] grid;

    public CellsGrid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Cell[rows][columns];
        initializeGridAsDeadGrid();
    }

    private void initializeGridAsDeadGrid() {
        for(int row = 0; row < rows; row++){
            for(int column = 0; column < columns; column++){
                grid[row][column] = new DeadCell();
            }
        }
    }

    public int getRowCount() {
        return rows;
    }

    public int getColumnCount() {
        return columns;
    }

    public boolean isCellInPositionLive(int row, int column) {
        return grid[row][column] instanceof LiveCell;
    }

    public void killCellInPosition(int row, int column) {
        grid[row][column] = new DeadCell();
    }

    public void giveLiveToCellInPosition(int row, int column) {
        grid[row][column] = new LiveCell();
    }
}
