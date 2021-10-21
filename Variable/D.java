package Variable;
public class D extends Variable {
    public D() {
        name = "D";
        constrainsWith[0] = "C";
        constrainsWith[1] = "H";
        constrainsWith[2] = "G";
        constrainsWith[3] = "F";
        constrainsWith[4] = "E";
    }

    public boolean checkConstraint(String name, int valD, int valO) {
        switch (name) {
            case "C":
                return DC(valD, valO);
            case "H":
                return DH(valD, valO);
            case "G":
                return DG(valD, valO);
            case "F":
                return DF(valD, valO);
            case "E":
                return DE(valD, valO);
            default:
                return false;
        }
    }

    private boolean DC(int valD, int valC) {
        return (valD != valC);
    }

    private boolean DH(int valD, int valH) {
        return (valH != valD);
    }

    private boolean DG(int valD, int valG) {
        return (valD >= valG);
        
    }

    private boolean DF(int valD, int valF) {
        return valF != valD;
    }

    private boolean DE(int valD, int valE) {
        return (valE < (valD - 1));
    }
    
}
