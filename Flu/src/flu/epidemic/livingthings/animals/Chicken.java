package flu.epidemic.livingthings.animals;

import flu.epidemic.livingthings.BeingsType;
import flu.epidemic.state.StateType;
import flu.epidemic.virus.H5N1;
import flu.epidemic.virus.VirusType;

public class Chicken extends Animal {

    public Chicken() {
        super(BeingsType.CHICKEN);
        this.virus = new H5N1();
    }

}
