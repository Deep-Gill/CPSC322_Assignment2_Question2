package Variable;
public class A extends Variable {

    public A() {
        name = "A";
        constrainsWith[0] = "G";
        constrainsWith[1] = "H";
    }

    public boolean checkConstraint(String name, int valA, int valO) {
        switch (name) {
            case "G":
                return AG(valA, valO);
            case "H":
                return AH(valA, valO);
            default:
                return false;

        }
    }

    public static boolean AG(int valA, int valG) {
        return (valA >= valG);
    }

    public static boolean AH(int valA, int valH) {
        return (valA < valH);
    }

}
