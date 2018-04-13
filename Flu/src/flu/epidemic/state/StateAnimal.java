package flu.epidemic.state;

import flu.epidemic.livingthings.BeingsType;
import flu.epidemic.virus.Virus;

public class StateAnimal extends State {
    private BeingsType animal;
    
    public StateAnimal(StateType stateType, BeingsType animal) {
        super(stateType);
        this.animal = animal;
    }
    
    
    @Override
    public StateType getState(Virus virus, int timeInfection, int timeContagious, int timeRecover) {
        if(currentState.isEquals(StateType.HEALTHY)) {
            currentState = situationStateHeathly();
        }else if (currentState.isEquals(StateType.SICK)) {
            currentState = situationStateSick(virus, timeInfection);
        }else if (currentState.isEquals(StateType.CONTAGIOUS)) {
            currentState = situationStateContagious(virus, timeContagious);
        }            
        return currentState;

    }
    

    
    @Override
    public StateType situationStateSick(Virus virus, int timeInfection) {
        if(timeInfection >= virus.getIncubationTime())
            return StateType.CONTAGIOUS;
        return StateType.SICK;  //?
    }

    @Override
    public StateType situationStateContagious(Virus virus, int timeContagious) {
        if(timeContagious == virus.getContagiousTime()) {
            return  StateType.DEAD;
        }
        return StateType.CONTAGIOUS;
    }

    @Override
    public StateType situationStateHeathly() {
        // TODO Auto-generated method stub
        return null;
        
    }


    @Override
    public StateType getState(boolean healthyPerson, Virus virus, int timeInfection, int timeContagious,
            int timeRecover) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public StateType situationStateContagious(boolean healthyPerson, Virus virus, int timeContagious) {
        // TODO Auto-generated method stub
        return null;
    }







 

    
    
    
    
}
