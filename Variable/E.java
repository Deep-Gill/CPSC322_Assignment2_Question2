package Variable;

import java.util.ArrayList;

public class E extends Variable {
    public E() {
        name = "E";
        constrainsWith = new ArrayList<String>(4);
        constrainsWith.add("D");
        constrainsWith.add("C");
        constrainsWith.add("H");
        constrainsWith.add("F");
    }

    public boolean checkConstraint(String name, int valE, int valO) {
        switch (name) {
            case "D":
                return ED(valE, valO);
            case "C":
                return EC(valE, valO);
            case "H":
                return EH(valE, valO);
            case "F":
                return EF(valE, valO);
            default:
                return false;
        }
    }

    private boolean ED(int valE, int valD) {
        return (valE < (valD - 1));
    }

    private boolean EC(int valE, int valC) {
        return (valE != valC);
    }

    private boolean EH(int valE, int valH) {
        return (valE != (valH - 2));
    }

    private boolean EF(int valE, int valF) {
        int diff = valE - valF;
        return (diff % 2 == 1);
    }
    
}
