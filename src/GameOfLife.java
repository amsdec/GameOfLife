/**
 * Created by alberto on 23/10/14.
 */
public class GameOfLife {

    public String[][] nextGeneration(String[][] grid) {
        for (int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid.length; column++) {
                String cell = grid[row][column];
                if(isCellLive(cell)) {
                    grid[row][column] = null;
                }
            }
        }
        return grid;
    }

    private boolean isCellLive(String s) {
        return s != null;
    }
}
