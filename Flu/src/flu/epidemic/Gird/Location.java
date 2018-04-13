package flu.epidemic.Gird;

import flu.epidemic.livingthings.livingbeings;

public class Location {
    private int row;
    private int col;
    private boolean isEmpty;
    private livingbeings beings;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
        isEmpty = true;
    }

    @Override
    public String toString() {
        return row + "," + col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    boolean addBeings(livingbeings being) {
       if(! isEmpty)
           return false;
       this.setBeings(being);
       return true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
    
    void isOccupy() {
        isEmpty = false;
    }
    
    public livingbeings getBeings() {
        return beings;
    }

    public void setBeings(livingbeings being) {
        this.beings = being;
    }
    
    public void exchangeBeings(Location location) {
        livingbeings beingA = location.getBeings();
        boolean flag = location.isEmpty;
        location.isEmpty = this.isEmpty;
        location.setBeings(this.beings);
        this.setBeings(beingA);
        isEmpty = flag;
        
    }

    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location other = (Location) obj;
            return row == other.getRow() && col == other.getCol();
        } else {
            return false;
        }
    }

 
}
