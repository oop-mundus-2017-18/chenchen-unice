package flu.epidemic.state;

import flu.epidemic.Gird.Location;
import flu.epidemic.Gird.World;
import flu.epidemic.livingthings.livingbeings;
import flu.epidemic.virus.Virus;
import flu.epidemic.virus.VirusType;

public abstract class State {
    protected StateType currentState;
    protected Virus currentVirus;
    protected World world;
    protected Location location;
    
    public State(StateType state, World world, Location location) {
        this.currentState = state;  
        this.world = world;
        this.location = location;
    }
    
    public State(StateType state) {
        this.currentState = state;
    }

    public abstract StateType situationStateSick(Virus virus, int dayInfection);
    public abstract StateType situationStateContagious(Virus virus, int dayContagious);
    public abstract StateType situationStateHeathly();
    public abstract StateType getState(Virus virus, int dayInfection, int dayContagious, int dayRecover);

    public abstract StateType getState(boolean healthyPerson, Virus virus, int dayInfection, int dayContagious,
            int dayRecover);

    public abstract StateType situationStateContagious(boolean healthyPerson, Virus virus, int dayContagious) ;  
    
    public Virus getCurrentVirus() {
        return currentVirus;
    }
    

    public StateType getState(Virus virus, int dayInfection, int dayContagious) {
        // TODO Auto-generated method stub
        return null;
    }

}
