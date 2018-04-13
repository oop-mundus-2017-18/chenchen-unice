package flu.epidemic.livingthings.animals;

import java.util.Random;

import flu.epidemic.livingthings.BeingsType;
import flu.epidemic.livingthings.livingbeings;
import flu.epidemic.state.State;
import flu.epidemic.state.StateAnimal;
import flu.epidemic.state.StateType;
import flu.epidemic.virus.VirusType;

public abstract class Animal extends livingbeings{
    
  private int dayInfection;
  private int dayRecover;
  private int dayContagious;
  State currentState;

    public Animal(BeingsType being) {
        super(being, StateType.SICK);
        Random rand = new Random();
        if(rand.nextBoolean()) {
            this.state = StateType.SICK;
        }else {this.state = StateType.HEALTHY;}
        
       this.currentState = new StateAnimal(this.state, being);     
    }
    
    @Override
    public void act() {
        if (isAlive()) {
            updateTime();

            this.state = currentState.getState(virus, dayInfection, dayContagious, dayRecover);

            if (state.isEquals(StateType.DEAD)) {
                setDead();
            }
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
        return false;
    }
    
}

