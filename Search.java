import java.util.ArrayList;
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
    private static ArrayList<String> order;
    private static Stack<Node> frontier;

    public static void main(String[] args) {
        initializeOrder(args);
        frontier = new Stack<Node>();
        Node parent = new Node(null, null, 0, 0);
        initializeNextLevel(parent, order.get(0), 0);
        updateFrontier(parent);
        Node current = frontier.pop();
        DFS(current, 1);
    }

    private static void DFS(Node current, int depth) {
        String indent = getIndent(depth);
        if (containsConstraintViolations(current, current.getParent())) {
            System.out.println(indent + current.getVariableName() + " = " + current.getValue() + " FAILURE");
        } else {
            if (depth != order.size()) {
                System.out.println(indent + current.getVariableName() + " = " + current.getValue());
                initializeNextLevel(current, order.get(depth), depth);
                updateFrontier(current);
            } else {
                System.out.println(indent + current.getVariableName() + " = " + current.getValue() + " SUCCESS");
            }
        }
        if (!frontier.isEmpty()) {
            current = frontier.pop();
            DFS(current, current.getDepth());
        }
    }

    private static String getIndent(int depth) {
        switch (depth) {
            case 1:
                return " ";
            case 2:
                return "  ";
            case 3:
                return "   ";
            case 4:
                return "    ";
            case 5:
                return "     ";
            case 6:
                return "      ";
            case 7:
                return "       ";
            case 8:
                return "        ";
            default:
                return "";
        }
    }

    private static void updateFrontier(Node parent) {
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
        order = new ArrayList<String>();
        for (int i = 0; i < args.length; i++) {
            order.add(args[i]);
        }
    }

}
