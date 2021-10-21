package Variable;

import java.util.ArrayList;

public class A extends Variable {

    public A() {
        name = "A";
        constrainsWith = new ArrayList<String>(2);
        constrainsWith.add("G");
        constrainsWith.add("H");
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
