package flu.epidemic.virus;

public enum VirusType {
    H1N1("H1N1"),
    H5N1("H5N1");
    
    private String virus = "";
    
    
    VirusType(String virus) {
       this.virus = virus;
    }

    public String toString() {
        return this.virus;
    }
    
}
