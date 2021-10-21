package Variable;
public class B extends Variable {
    public B() {
        name = "B";
        constrainsWith[0] = "F";
    }

    public boolean checkConstraint(String name, int valB, int valO) {
        if (name == "F") {
            return BF(valB, valO);
        }
        return false;
    }

    public static boolean BF(int valB, int valF) {
        return ((valF - valB == 1) || (valF - valB == -1));
    }

}
