package Variable;

import java.util.ArrayList;

public class G extends Variable {

    public G() {
        name = "G";
        constrainsWith = new ArrayList<String>(5);
        constrainsWith.add("F");
        constrainsWith.add("D");
        constrainsWith.add("C");
        constrainsWith.add("H");
        constrainsWith.add("A");
    }

    public boolean checkConstraint(String name, int valG, int valO) {
        switch (name) {
            case "F": 
                return GF(valG, valO);  
            case "D":
                return GD(valG, valO);
            case "C":
                return GC(valG, valO);
            case "H":
                return GH(valG, valO);
            case "A":
                return GA(valG, valO);
            default:
                return false;
        }
    }

    private boolean GF(int valG, int valF) {
        return (valG != valF);
    }

    private boolean GD(int valG, int valD) {
        return (valD >= valG);
        
    }

    private boolean GC(int valG, int valC) {
        int diff = valG - valC;
        return ((diff == 1) || (diff == -1));
    }

    private boolean GH(int valG, int valH) {
        return (valG < valH);
    }

    private boolean GA(int valG, int valA) {
        return (valA >= valG);
    }
    
}
