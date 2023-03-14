import java.util.LinkedList;
import java.util.Queue;

public class BInarySearchTree <T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    @Override
    public Tree<T> insert(T data) {
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
    Node<T> getPredecessor(Node<T> node) {
        if (node.getRight() != null) {
            return getPredecessor(node.getRight());
        }
        return node;
    }
    //heavily Recursive
    Node<T>insert(T newData, Node<T> node) {
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
}
