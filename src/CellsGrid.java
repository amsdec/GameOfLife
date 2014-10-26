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
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid.length; column++){
                grid[row][column] = new Cell(false);
            }
        }
    }

    public int getRowCount() {
        return rows;
    }

    public int getColumnCount() {
        return columns;
    }

    public Cell getCellInPosition(int row, int column) {
        return grid[row][column];
    }
}
