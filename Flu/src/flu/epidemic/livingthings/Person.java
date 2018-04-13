package flu.epidemic.livingthings;

import java.util.Random;

import flu.epidemic.Gird.Location;
import flu.epidemic.Gird.World;
import flu.epidemic.state.StateType;
import flu.epidemic.state.State;
import flu.epidemic.state.StatePerson;

public class Person extends livingbeings {

    private static final double VACCINATED_RATE = 0.2;
    private static final double INFECTED_RATE = 0.5;
    State currentState;
    private int dayInfection;
    private int dayContagious;
    private int dayRecover;
    private boolean isVaccinated;
    private boolean isResistant;
    private boolean healthyPerson;

    public Person() {
        super(BeingsType.PERSON, StateType.HEALTHY);
        this.currentState = new StatePerson(StateType.HEALTHY);
        this.dayInfection = 0;
        isVaccinated = false;
        isResistant = false;
        this.dayContagious = 0;
        this.dayRecover = 0;


    }

    @Override
    public void act() {
        if (isAlive()) {
            updateTime();

            if (!isVaccinated && !isResistant)
                this.state = currentState.getState(healthyPerson, virus, dayInfection, dayContagious, dayRecover);

                if (state.isEquals(StateType.HEALTHY)) {
                    Random random = new Random();
                    if (random.nextDouble() <= VACCINATED_RATE)
                        isVaccinated = true;
                } else {
                    isResistant = true;
                }

                
            } else if (state.isEquals(StateType.DEAD)) {
                setDead();
            }
        }

    public boolean isInfected(Location location) {
        Random random = new Random();

        if(location.getBeings().state.isEquals(StateType.CONTAGIOUS) || random.nextDouble() <= INFECTED_RATE) {
            return true;
        }else {
            return false;
            }
    }
    
    @Override
    protected void updateTime() {
        if (state.isEquals(StateType.SICK)) {
            virus = currentState.getCurrentVirus();
            dayInfection++;
        }
        if (state.isEquals(StateType.CONTAGIOUS))
            dayContagious++;
        if (state.isEquals(StateType.RECOVERING))
            dayRecover++;
    }

    @Override
    public boolean isResistant() {
        return isResistant;
    }

}
