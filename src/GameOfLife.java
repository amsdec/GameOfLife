/**
 * Created by alberto on 23/10/14.
 */
public class GameOfLife {

    public String[][] nextGeneration(String[][] grid) {
        for (int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid.length; column++) {
                if(grid[row][column] != null) {
                    grid[row][column] = null;
                }
            }
        }
        return grid;
    }
}
