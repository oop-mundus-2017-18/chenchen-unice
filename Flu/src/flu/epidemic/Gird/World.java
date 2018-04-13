package flu.epidemic.Gird;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import flu.epidemic.livingthings.livingbeings;

public class World {

    public static final int SIZE = 10;
    final Location[][] locations = new Location[SIZE][SIZE];
    List<Location> emptyGird = new ArrayList<>();
    Random rand = new Random();

    World() {
        for (int row = 0; row < SIZE; row++)
            for (int col = 0; col < SIZE; col++) {
                locations[row][col] = new Location(row, col);
                emptyGird.add(locations[row][col]);
            }
    }

    void addBeings(livingbeings being) {
        if (emptyGird.isEmpty())
            throw new RuntimeException("no space");
        int target = rand.nextInt(emptyGird.size());
        emptyGird.get(target).addBeings(being);
        emptyGird.get(target).isOccupy();
        emptyGird.remove(target);
    }
    
    void move() {
        for (int row = 0; row < SIZE; row++)
            for (int col = 0; col < SIZE; col++) {
                int target = rand.nextInt(7);
                Location[] neighbors = getNeighbor(row, col);
                locations[row][col].exchangeBeings(neighbors[target]);
            }
    }


    public Location[] getNeighbor(Location location) {
        int row = location.getRow();
        int col = location.getCol();
        int DownRow = row - 1;
        int UpRow = row + 1;
        int LeftCol = col - 1;
        int RightCol = col + 1;
        if (row + 1 > SIZE - 1)
            UpRow = 0;
        if (row - 1 < 0)
            DownRow = SIZE - 1;
        if (col + 1 > SIZE - 1)
            RightCol = 0;
        if (col - 1 < 0)
            LeftCol = SIZE - 1;
        Location[] neighbor = new Location[8];
        neighbor[0] = locations[row][RightCol];
        neighbor[1] = locations[row][LeftCol];
        neighbor[2] = locations[UpRow][RightCol];
        neighbor[3] = locations[UpRow][col];
        neighbor[4] = locations[UpRow][LeftCol];
        neighbor[5] = locations[DownRow][LeftCol];
        neighbor[6] = locations[DownRow][col];
        neighbor[7] = locations[DownRow][RightCol];
        return neighbor;
        
    }
    
    Location[] getNeighbor(int row, int col) {
        int DownRow = row - 1;
        int UpRow = row + 1;
        int LeftCol = col - 1;
        int RightCol = col + 1;
        if (row + 1 > SIZE - 1)
            UpRow = 0;
        if (row - 1 < 0)
            DownRow = SIZE - 1;
        if (col + 1 > SIZE - 1)
            RightCol = 0;
        if (col - 1 < 0)
            LeftCol = SIZE - 1;
        Location[] neighbor = new Location[8];
        neighbor[0] = locations[row][RightCol];
        neighbor[1] = locations[row][LeftCol];
        neighbor[2] = locations[UpRow][RightCol];
        neighbor[3] = locations[UpRow][col];
        neighbor[4] = locations[UpRow][LeftCol];
        neighbor[5] = locations[DownRow][LeftCol];
        neighbor[6] = locations[DownRow][col];
        neighbor[7] = locations[DownRow][RightCol];
        return neighbor;
        
    }
    
    Location getLocation(int row, int col) {
        return locations[row][col];
    }

}
