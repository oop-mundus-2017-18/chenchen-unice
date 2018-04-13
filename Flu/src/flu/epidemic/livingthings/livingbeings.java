package flu.epidemic.livingthings;

import flu.epidemic.Gird.Location;
import flu.epidemic.Gird.World;
import flu.epidemic.state.StateType;
import flu.epidemic.virus.Virus;
import flu.epidemic.virus.VirusType;

public abstract class livingbeings {
    protected Virus virus;
    protected BeingsType being;
    protected StateType state;
    protected World world;
    protected Location loc;
    protected boolean alive;

    public livingbeings(BeingsType being, StateType state) {
        this.virus = null;
        this.being = being;
        this.state = state;
        this.alive = true;
    }

    abstract public void act();

    public boolean isAlive() {
        return alive;
    }

    protected void setDead() {
        alive = false;
    }

    public Virus getVirus() {
        return virus;
    }

    public BeingsType getBeing() {
        return being;
    }

    public StateType getState() {
        return state;
    }


    abstract public boolean isResistant();

    public void setResistance(boolean resistant) {
    }

    protected abstract void updateTime();
}
