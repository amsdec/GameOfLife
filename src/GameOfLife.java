/**
 * Created by alberto on 23/10/14.
 */
public class GameOfLife {

    public String[][] nextGeneration(String[][] grid) {
        for (int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid.length; column++) {
                String cell = grid[row][column];
                int liveNeighbors = 0;
                if(isCellLive(cell)) {
                    if(row -1 > -1  && column -1 > -1 && isCellLive(grid[row-1][column-1])){
                        liveNeighbors++;
                    }
                    if(column -1 > -1 && isCellLive(grid[row][column-1])){
                        liveNeighbors++;
                    }
                    if(row +1 < grid.length  && column -1 > -1 && isCellLive(grid[row+1][column-1])){
                        liveNeighbors++;
                    }
                    if(row -1 > -1  && isCellLive(grid[row-1][column])){
                        liveNeighbors++;
                    }
                    if(row +1 < grid.length && isCellLive(grid[row+1][column])){
                        liveNeighbors++;
                    }
                    if(row -1 > -1  && column +1 < grid.length && isCellLive(grid[row-1][column+1])){
                        liveNeighbors++;
                    }
                    if(column +1 < grid.length && isCellLive(grid[row][column+1])){
                        liveNeighbors++;
                    }
                    if(row +1 < grid.length && column +1 < grid.length && isCellLive(grid[row+1][column+1])){
                        liveNeighbors++;
                    }
                    if(liveNeighbors != 2) {
                        grid[row][column] = null;
                    }
                }
            }
        }
        return grid;
    }

    private boolean isCellLive(String s) {
        return s != null;
    }
}
