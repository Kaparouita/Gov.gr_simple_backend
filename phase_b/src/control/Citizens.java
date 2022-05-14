package control;

import java.util.List;

public class Citizens {
    private List<Citizens> citizens;

    public Citizens(){}
    public Citizens(List<Citizens>citizens){

    }

    public List<Citizens> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizens> citizens) {
        this.citizens = citizens;
    }
}
