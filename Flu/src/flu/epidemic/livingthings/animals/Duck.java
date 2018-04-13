package flu.epidemic.livingthings.animals;

import flu.epidemic.livingthings.BeingsType;
import flu.epidemic.state.StateType;
import flu.epidemic.virus.H5N1;


public class Duck extends Animal {

    public Duck() {
        super(BeingsType.DUCK);
        this.virus = new H5N1();
    }
    
   

}
