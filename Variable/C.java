package Variable;

import java.util.ArrayList;

public class C extends Variable {
    public C() {
        name = "C";
        constrainsWith = new ArrayList<String>(5);
        constrainsWith.add("H");
        constrainsWith.add("G");
        constrainsWith.add("F");
        constrainsWith.add("E");
        constrainsWith.add("D");
    }

    public boolean checkConstraint(String name, int valC, int valO) {
        switch (name) {
            case "H":
                return CH(valC, valO);
            case "G":
                return CG(valC, valO);
            case "F":
                return CF(valC, valO);
            case "E":
                return CE(valC, valO);
            case "D":
                return CD(valC, valO);
            default:
                return false;
        }
    }

    private boolean CH(int valC, int valH) {
        int diff = valH - valC;
        return (diff % 2 == 0);
    }

    private boolean CG(int valC, int valG) {
        int diff = valG - valC;
        return ((diff == 1) || (diff == -1));
    }

    private boolean CF(int valC, int valF) {
        return (valF != valC);
    }

    private boolean CE(int valC, int valE) {
        return (valE != valC);
    }

    private boolean CD(int valC, int valD) {
        return (valD != valC);
    }
}
