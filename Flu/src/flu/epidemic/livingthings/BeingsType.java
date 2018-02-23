package flu.epidemic.livingthings;

public enum BeingsType {
    PERSON("person"),
    CHICKEN("chicken"),
    DUCK("duck"),
    PIG("pig");
    
    private String being = "";
    
    BeingsType(String being){
        this.being = being;
    }
    
    public String toString() {
        return this.being;
    }
}
