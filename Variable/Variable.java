package Variable;

import java.util.ArrayList;

public abstract class Variable {
    protected String name;
    protected ArrayList<String> constrainsWith;

    public Variable() {

    }

    public abstract boolean checkConstraint(String name, int val, int valO);
    
    public String getName() {
        return name;
    }

    public ArrayList<String> getConstraintsVariables() {
        return constrainsWith;
    }
}
