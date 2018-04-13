package flu.epidemic.state;

import java.util.Random;

import flu.epidemic.Gird.Location;
import flu.epidemic.livingthings.Person;
import flu.epidemic.livingthings.livingbeings;
import flu.epidemic.virus.Virus;

public class StatePerson extends State {

    public StatePerson(StateType stateType) {
        super(stateType);
    }

    @Override
    public StateType getState(boolean healthyPerson, Virus virus, int dayInfection, int dayContagious, int dayRecover) {
        // if (currentState.isEquals(StateType.HEALTHY)) {
        // currentState = situationStateHeathly();
        // }
           if (currentState.isEquals(StateType.SICK)) {
           currentState = situationStateSick(virus, dayInfection);
        } else if (currentState.isEquals(StateType.CONTAGIOUS)) {
            currentState = situationStateContagious(virus, dayContagious);
        } else if (currentState.isEquals(StateType.RECOVERING)) {
            currentState = situationStateRecover(virus, dayRecover);
        }
        return currentState;
    }

    @Override
    public StateType situationStateSick(Virus virus, int dayInfection) {
        if (dayInfection >= virus.getContagiousTime()) {
            return StateType.CONTAGIOUS;
        }
        return StateType.SICK;
    }

    @Override
    public StateType situationStateContagious(boolean healthyPerson, Virus virus, int dayContagious) {
        Random rand = new Random();
        if (dayContagious == virus.getContagiousTime()) {
            if (rand.nextDouble() <= virus.getDeadRate() && !healthyPerson)
                return StateType.DEAD;
            else
                return StateType.RECOVERING;
        }
        return StateType.CONTAGIOUS;
    }

    @Override
    public StateType situationStateHeathly() {
        for (Location loc : world.getNeighbor(location)) {
            Random rand = new Random(); //???
            livingbeings beings = new Person();
            if (beings != null) {
                if (beings.getState().isEquals(StateType.CONTAGIOUS)) {
                    if (rand.nextDouble() <= beings.getVirus().getInfectionRate()) {
                        currentVirus = beings.getVirus();
                        return StateType.SICK;
                    }
                } else if (beings.isResistant()) {
                    return StateType.RECOVERING;
                }
            }
        }
        return StateType.HEALTHY;

    }

    private StateType situationStateRecover(Virus virus, int dayRecoer) {
        if (dayRecoer == virus.getRecoverTime()) {
            return StateType.HEALTHY;
        }
        return StateType.RECOVERING;
    }

    @Override
    public StateType situationStateContagious(Virus virus, int dayContagious) {
        return null;
    }

    @Override
    public StateType getState(Virus virus, int dayInfection, int dayContagious, int timeRecover) {
        return null;
    }

}
