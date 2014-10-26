/**
 * Created by alberto on 26/10/14.
 */
public class Cell {
    private boolean isLive;

    public Cell(boolean isLive){
        this.isLive = isLive;
    }

    public boolean isLive() {
        return this.isLive;
    }

    public void kill() {
        this.isLive = false;
    }

    public void giveLive() {
        this.isLive = true;
    }
}
