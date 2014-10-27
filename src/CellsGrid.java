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
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
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

    @Override
    public String toString() {
        StringBuilder printVersion = new StringBuilder();
        for(int x = 0; x < this.getRowCount(); x++) {
            for(int y = 0; y < this.getColumnCount(); y++) {
                printVersion.append(grid[x][y].toString());
            }
            printVersion.append("\n");
        }
        return removeLastEndOfLine(printVersion);
    }

    private String removeLastEndOfLine(StringBuilder printVersion) {
        return printVersion.toString().substring(0, printVersion.toString().length() -1);
    }
}
