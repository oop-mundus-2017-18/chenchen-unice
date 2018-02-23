package flu.epidemic.livingthings;

import flu.epidemic.state.StateType;

public class Person {

    protected BeingsType being;
    protected StateType state;

    Person(BeingsType being,StateType state) {
        this.being = being;
        this.state = state;

    }

}
