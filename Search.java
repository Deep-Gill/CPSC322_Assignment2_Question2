import java.util.Stack;

import Node.Node;
import Variable.A;
import Variable.B;
import Variable.C;
import Variable.D;
import Variable.E;
import Variable.F;
import Variable.G;
import Variable.H;
import Variable.Variable;

public class Search {
    private static String[] order;
    private static Stack<Node> frontier;

    public static void main(String[] args) {
        initializeOrder(args);
        int n = args.length;
        Node parent = new Node(null, null, 0, 0);
        initializeNextLevel(parent, order[0], 0);
        updateStack(parent);
        Node current = frontier.pop();
        DFS(current, 1);
    }

    private static void DFS(Node current, int depth) {
        if (containsConstraintViolations(current, current.getParent())) {
            System.out.println(" " + current.getVariableName() + " = " + current.getValue() + " FAILURE");
        } else {
            if (depth != order.length) {
                System.out.println(" " + current.getVariableName() + " = " + current.getValue());
                initializeNextLevel(current, order[depth], depth);
                updateStack(current);
            } else {
                System.out.println(" " + current.getVariableName() + " = " + current.getValue() + " SUCCESS");
            }
        }
        if (!frontier.isEmpty()) {
            current = frontier.pop();
            DFS(current, current.getDepth());
        }
    }

    private static void updateStack(Node parent) {
        frontier.push(parent.getFourth());
        frontier.push(parent.getThird());
        frontier.push(parent.getSecond());
        frontier.push(parent.getFirst());
    }

    private static boolean containsConstraintViolations(Node current, Node parent) {
        if (parent.getParent() == null) {
            return false;
        }

        if (current.validateConstraintsWith(parent)) {
            return containsConstraintViolations(current, parent.getParent());
        } else {
            return true;
        }
    }

    // depth is parent's depth
    private static void initializeNextLevel(Node parent, String variable, int depth) {
        Variable var1 = instantiateVariable(variable);
        Node node1 = new Node(parent, var1, 1, depth + 1);
        parent.setFirst(node1);

        Variable var2 = instantiateVariable(variable);
        Node node2 = new Node(parent, var2, 2, depth + 1);
        parent.setSecond(node2);

        Variable var3 = instantiateVariable(variable);
        Node node3 = new Node(parent, var3, 3, depth + 1);
        parent.setThird(node3);

        Variable var4 = instantiateVariable(variable);
        Node node4 = new Node(parent, var4, 4, depth + 1);
        parent.setFourth(node4);
    }

    private static Variable instantiateVariable(String variable) {
        Variable v;
        switch (variable) {
        case "A":
            v = new A();
            break;
        case "B":
            v = new B();
            break;
        case "C":
            v = new C();
            break;
        case "D":
            v = new D();
            break;
        case "E":
            v = new E();
            break;
        case "F":
            v = new F();
            break;
        case "G":
            v = new G();
            break;
        case "H":
            v = new H();
            break;
        default:
            v = null;
            break;
        }
        return v;
    }

    private static void initializeOrder(String[] args) {
        for (int i = 0; i < args.length; i++) {
            order[i] = args[i];
        }
    }

}
