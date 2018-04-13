package flu.epidemic.Gird;

import java.util.List;
import java.util.Random;

import flu.epidemic.livingthings.Person;
import flu.epidemic.livingthings.livingbeings;
import flu.epidemic.livingthings.animals.Chicken;
import flu.epidemic.livingthings.animals.Duck;
import flu.epidemic.livingthings.animals.Pig;

public class simulator {
    private static final double PERSON_CREATION_PROBABILITY = 0.08;
    private static final double CHICKEN_CREATION_PROBABILITY = 0.01; 
    private static final double DUCK_CREATION_PROBABILITY = 0.02; 
    private static final double PIG_CREATION_PROBABILITY = 0.03; 
    private World world = new World();
    private List<livingbeings> livingBeings;
    
    
    
    void initial() {
        Random rand = new Random();
        for (int row = 0; row < world.SIZE; row++)
            for (int col = 0; col < world.SIZE; col++) {
                if (rand.nextDouble() <= DUCK_CREATION_PROBABILITY) {
                    livingbeings duck = new Duck();
                    world.addBeings(duck);
                    livingBeings.add(duck);
                }else if (rand.nextDouble() <= CHICKEN_CREATION_PROBABILITY) {
                    livingbeings chicken = new Chicken();
                    world.addBeings(chicken);
                    livingBeings.add(chicken);
                }else if (rand.nextDouble() <= PIG_CREATION_PROBABILITY) {
                    livingbeings pig = new Pig();
                    world.addBeings(pig);
                    livingBeings.add(pig);
                }else if (rand.nextDouble() <= PERSON_CREATION_PROBABILITY) {
                    livingbeings person = new Person();
                    world.addBeings(person);
                    livingBeings.add(person);
                }              
        }
    }
    
    void run(int days) {
        for (int i = 0; i < days; i++) {
            move();
            System.out.println("DAY: " + i);
        }
    }
    
        
        public void simulateOneStep() {           
            for (int i = 0; i < livingBeings.size() - 1; i++) {
                livingbeings being = livingBeings.get(i);
                being.act();
                if (being.isAlive()) {
                    livingBeings.set(i, being);
                }
            }
        }
    
    
    
    
    void move() {
        world.move();
    }
    
    @Override
    public String toString() {
        return world.toString();
    }
}


