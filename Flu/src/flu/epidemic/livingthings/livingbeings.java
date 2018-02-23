package flu.epidemic.livingthings;

import flu.epidemic.state.StateType;
import flu.epidemic.virus.VirusType;

public abstract class livingbeings {
    protected VirusType virus;
    protected BeingsType being;
    protected StateType state;

    public livingbeings(VirusType virus, BeingsType being, StateType state) {
        this.virus = virus;
        this.being = being;
        this.state = state;
    }

}
