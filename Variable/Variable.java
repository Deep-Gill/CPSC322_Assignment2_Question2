package Variable;

public abstract class Variable {
    protected String name;
    protected String[] constrainsWith;

    public Variable() {

    }

    public abstract boolean checkConstraint(String name, int val, int valO);
    
    public String getName() {
        return name;
    }

    public String[] getConstraintsVariables() {
        return constrainsWith;
    }
}
