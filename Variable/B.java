package Variable;

import java.util.ArrayList;

public class B extends Variable {
    public B() {
        name = "B";
        constrainsWith = new ArrayList<String>(1);
        constrainsWith.add("F");
    }

    public boolean checkConstraint(String name, int valB, int valO) {
        if (name == "F") {
            return BF(valB, valO);
        }
        return false;
    }

    public static boolean BF(int valB, int valF) {
        int diff = valF - valB;
        return ((diff == 1) || (diff == -1));
    }

}
