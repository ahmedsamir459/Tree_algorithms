package Trees;

import java.awt.*;
import java.util.*;
import java.util.List;

public class BInarySearchTree <T extends Comparable<T>> implements ITree<T> {
    private Node<T> root;

    @Override
    public ITree<T> insert(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            insertNode(data, root);
        }
        return this;
    }
    void insertNode(T newData, Node<T> node) {
        if (newData.compareTo(node.getData()) < 0) {


            if (node.getLeft() != null) {
                insertNode(newData, node.getLeft());
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setLeft(newNode);
            }


        } else {
            if (node.getRight() != null) {
                insertNode(newData, node.getRight());
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setRight(newNode);
            }
        }
    }
    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRight() != null) {
            return getPredecessor(node.getRight());
        }
        return node;
    }
    //heavily Recursive
    private Node<T>insert(T newData, Node<T> node) {
        if (node == null) {
            return new Node<>(newData);
        }
        if (newData.compareTo(node.getData()) < 0) {
            node.setLeft(insert(newData, node.getLeft()));
        } else {
            node.setRight(insert(newData, node.getRight()));
        }
        return node;
    }
    @Override
    public void remove(T data) {
        root = remove(data, root);
    }
    Node<T> remove(T data, Node<T> node){
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData())<0){
            node.setLeft(remove(data, node.getLeft()));
        }
        else if (data.compareTo(node.getData())>0){
            node.setRight(remove(data, node.getRight()));
        }
        else {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
        Node<T> temp = getPredecessor(node.getLeft());
        node.setData(temp.getData());
        node.setLeft(remove(temp.getData(), node.getLeft()));
        }
        return node;
    }


    @Override
    public void traverse() {
        if (root == null) {
            return;
        }
        System.out.println("InOrderTraversal");
        inOrderTraversal(root);
        System.out.println("PreOrderTraversal");
        preOrderTraversal(root);
        System.out.println("PostOrderTraversal");
        postOrderTraversal(root);
    }
    void inOrderTraversal(Node<T> node){
        if (node!=null){
            inOrderTraversal(node.getLeft());
            System.out.println(node.getData());
            inOrderTraversal(node.getRight());
        }

    }
    void preOrderTraversal(Node<T> node){
        if (node!=null){
            System.out.println(node.getData());
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }

    }
    void postOrderTraversal(Node<T> node){
        if (node!=null){
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            System.out.println(node.getData());
        }

    }

    @Override
    public T getMin() {
        for (Node<T> node = root; node != null; node = node.getLeft()) {
            if (node.getLeft() == null) {
                return node.getData();
            }
        }
        return null;
    }

    @Override
    public T getMax() {
        for (Node<T> node = root; node != null; node = node.getRight()) {
            if (node.getRight() == null) {
                return node.getData();
            }
        }
        return null;
    }

    @Override
    public boolean contains(T data) {
        if (root == null) {
            return false;
        }
        Node<T> node = root;
        while (node != null) {
            if (data.compareTo(node.getData()) < 0) {
                node = node.getLeft();
            } else if (data.compareTo(node.getData()) > 0) {
                node = node.getRight();
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            size++;
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return size;
    }


    @Override
    public int height() {
        if (root == null) {
            return 0;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0) {
                return height;
            }
            height++;
            while (nodeCount > 0) {
                Node<T> node = queue.remove();
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
                nodeCount--;
            }
        }
    }
    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Node<T> getRoot() {
        return root;
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
