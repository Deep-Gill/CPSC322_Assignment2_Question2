package Variable;
public class H extends Variable {
    public H() {
        name = "H";
        constrainsWith[0] = "A";
        constrainsWith[1] = "G";
        constrainsWith[2] = "F";
        constrainsWith[3] = "E";
        constrainsWith[4] = "D";
        constrainsWith[5] = "C";
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
        return (valE != (valH - 2));
    }

    private boolean HD(int valH, int valD) {
        return (valH != valD);
    }

    private boolean HC(int valH, int valC) {
        int diff = valH - valC;
        return (diff % 2 == 0);
    }    
}
