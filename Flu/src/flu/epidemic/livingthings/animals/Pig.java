package flu.epidemic.livingthings.animals;

import flu.epidemic.livingthings.BeingsType;
import flu.epidemic.state.StateType;
import flu.epidemic.virus.H1N1;
import flu.epidemic.virus.H5N1;
import flu.epidemic.virus.VirusType;

public class Pig extends Animal {

    public Pig() {
        super(BeingsType.PIG);
        this.virus = new H1N1();
    }
    


}
