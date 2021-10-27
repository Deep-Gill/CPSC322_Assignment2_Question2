package Variable;

import java.util.ArrayList;

public class H extends Variable {
    public H() {
        name = "H";
        constrainsWith = new ArrayList<String>(6);
        constrainsWith.add("A");
        constrainsWith.add("G");
        constrainsWith.add("F");
        constrainsWith.add("E");
        constrainsWith.add("D");
        constrainsWith.add("C");
    }

    public boolean checkConstraint(String name, int valH, int valO) {
        switch (name) {
            case "A":
                return HA(valH, valO);
            case "G":
                return HG(valH, valO);
            case "F":
                return HF(valH, valO);
            case "E":
                return HE(valH, valO);
            case "D":
                return HD(valH, valO);
            case "C":
                return HC(valH, valO);
            default:
                return false;
        }
    }

    private boolean HA(int valH, int valA) {
        return (valA < valH);
    }

    private boolean HG(int valH, int valG) {
        return (valG < valH);
    }

    private boolean HF(int valH, int valF) {
        return (valF != valH);
    }

    private boolean HE(int valH, int valE) {
        int sub = valH - 2;
        return (valE != sub);
    }

    private boolean HD(int valH, int valD) {
        return (valH != valD);
    }

    private boolean HC(int valH, int valC) {
        int diff = valH - valC;
        return (diff % 2 == 0);
    }    
}
