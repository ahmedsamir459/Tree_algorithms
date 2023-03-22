import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ITree<Integer> tree = new RedBlackTree<>();
        tree.insert(10);
        printTree(tree.getRoot());
        tree.insert(24);
        printTree(tree.getRoot());
        tree.insert(8);
        printTree(tree.getRoot());
        tree.insert(18);
        printTree(tree.getRoot());
        tree.insert(17);
        printTree(tree.getRoot());
        tree.insert(22);
        printTree(tree.getRoot());
        tree.remove(17);
        printTree(tree.getRoot());

//        tree.insert(22);
//        printTree(tree.getRoot());
//        tree.insert(15);
//        printTree(tree.getRoot());
//        tree.insert(6);
//        printTree(tree.getRoot());
//        tree.insert(8);
//        printTree(tree.getRoot());
//        tree.remove(4);
//        printTree(tree.getRoot());
//        tree.remove(5);
//        printTree(tree.getRoot());
//        tree.remove(6);
//        printTree(tree.getRoot());
    }

    public static <T extends Comparable<T>> void printTree(Node<T> root) {
        printSubtree(Collections.singletonList(root), 1, getHeight(root));
    }

    private static <T extends Comparable<T>> void printSubtree(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.getData());
                System.out.print((node.getColor() == Color.RED) ? "R" : "B");
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (Node<T> node : nodes) {
                printWhitespaces(firstSpaces - i);
                if (node == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (node.getLeft() != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(2);
                }

                printWhitespaces(i + i - 1);

                if (node.getRight() != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(2);
                }

                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }

        printSubtree(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static <T extends Comparable<T>> int getHeight(Node<T> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (T element : list) {
            if (element != null) {
                return false;
            }
        }

        return true;
    }

}
