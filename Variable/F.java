package Variable;
public class F extends Variable {
    public F() {
        name = "F";
        constrainsWith[0] = "E";
        constrainsWith[0] = "C";
        constrainsWith[0] = "H";
        constrainsWith[0] = "G";
        constrainsWith[0] = "B";
    }

    public boolean checkConstraint(String name, int valF, int valO) {
        switch (name) {
            case "E":
                return FE(valF, valO); 
            case "C":
                return FC(valF, valO); 
            case "H":
                return FH(valF, valO); 
            case "G":
                return FG(valF, valO); 
            case "B":
                return FB(valF, valO); 
            default:
                return false;
        }
    }

    private boolean FE(int valF, int valE) {
        int diff = valE - valF;
        return (diff % 2 == 1);
    }

    private boolean FC(int valF, int valC) {
        return (valF != valC);
    }

    private boolean FH(int valF, int valH) {
        return (valF != valH);
    }

    private boolean FG(int valF, int valG) {
        return (valF != valG);
    }

    private boolean FB(int valF, int valB) {
        int diff = valF - valB;
        return ((diff == 1) || (diff == -1));
        
    }

    

    
}
