package Node;
import java.util.ArrayList;

import Variable.*;

public class Node {
    private Variable variable;
    private int value;
    private Node parent;
    private Node first;
    private Node second;
    private Node third;
    private Node fourth;
    private int depth;

    public Node(Node parent, Variable variable, int value, int depth) {
        this.parent = parent;
        this.variable = variable;
        this.value = value;
        this.depth = depth;
        first  = null;
        second = null;
        third  = null;
        fourth = null;
    }

    public void setFirst(Node node) {
        first = node;
    }

    public void setSecond(Node node) {
        second = node;
    }

    public void setThird(Node node) {
        third = node;
    }

    public void setFourth(Node node) {
        fourth = node;
    }

    public Node getFirst() {
        return first;
    }

    public Node getSecond() {
        return second;
    }

    public Node getThird() {
        return third;
    }

    public Node getFourth() {
        return fourth;
    }

    public Node getParent() {
        return parent;
    }

    public int getDepth() {
        return depth;
    }

    public String getVariableName() {
        return this.variable.getName();
    }

    public int getValue() {
        return value;
    }

    public boolean validateConstraintsWith(Node ancestor) {
        ArrayList<String> listOfConstraints = this.variable.getConstraintsVariables();
        int length = listOfConstraints.size();

        if (ancestor.getParent() == null) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (ancestor.getVariableName() == listOfConstraints.get(i)) {
                return this.variable.checkConstraint(ancestor.getVariableName(), this.value, ancestor.value);
            }
        }
        return true;
    }
    
}
