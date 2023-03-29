import java.util.LinkedList;
import java.util.Queue;


public class RB<T extends Comparable<T>> implements Tree {


    private RB_Node<T> nil = new RB_Node<T>();
    private RB_Node<T> root = nil;

    public RB() {
        root.left = nil;
        root.right = nil;
        root.parent = nil;
    }


    public RB_Node Root() {
        return root;
    }


    private void leftRotate(RB_Node<T> x) {


        leftRotateFixup(x);


        RB_Node<T> y;
        y = x.right;
        x.right = y.left;


        if (!isNil(y.left))
            y.left.parent = x;
        y.parent = x.parent;


        if (isNil(x.parent))
            root = y;


        else if (x.parent.left == x)
            x.parent.left = y;


        else
            x.parent.right = y;


        y.left = x;
        x.parent = y;
    }


    private void leftRotateFixup(RB_Node x) {


        if (isNil(x.left) && isNil(x.right.left)) {
            x.numLeft = 0;
            x.numRight = 0;
            x.right.numLeft = 1;
        } else if (isNil(x.left) && !isNil(x.right.left)) {
            x.numLeft = 0;
            x.numRight = 1 + x.right.left.numLeft +
                    x.right.left.numRight;
            x.right.numLeft = 2 + x.right.left.numLeft +
                    x.right.left.numRight;
        } else if (!isNil(x.left) && isNil(x.right.left)) {
            x.numRight = 0;
            x.right.numLeft = 2 + x.left.numLeft + x.left.numRight;

        } else {
            x.numRight = 1 + x.right.left.numLeft +
                    x.right.left.numRight;
            x.right.numLeft = 3 + x.left.numLeft + x.left.numRight +
                    x.right.left.numLeft + x.right.left.numRight;
        }

    }


    private void rightRotate(RB_Node<T> y) {


        rightRotateFixup(y);


        RB_Node<T> x = y.left;
        y.left = x.right;


        if (!isNil(x.right))
            x.right.parent = y;
        x.parent = y.parent;


        if (isNil(y.parent))
            root = x;


        else if (y.parent.right == y)
            y.parent.right = x;


        else
            y.parent.left = x;
        x.right = y;

        y.parent = x;

    }


    private void rightRotateFixup(RB_Node y) {


        if (isNil(y.right) && isNil(y.left.right)) {
            y.numRight = 0;
            y.numLeft = 0;
            y.left.numRight = 1;
        } else if (isNil(y.right) && !isNil(y.left.right)) {
            y.numRight = 0;
            y.numLeft = 1 + y.left.right.numRight +
                    y.left.right.numLeft;
            y.left.numRight = 2 + y.left.right.numRight +
                    y.left.right.numLeft;
        } else if (!isNil(y.right) && isNil(y.left.right)) {
            y.numLeft = 0;
            y.left.numRight = 2 + y.right.numRight + y.right.numLeft;

        } else {
            y.numLeft = 1 + y.left.right.numRight +
                    y.left.right.numLeft;
            y.left.numRight = 3 + y.right.numRight +
                    y.right.numLeft +
                    y.left.right.numRight + y.left.right.numLeft;
        }

    }


    public boolean insertRB(T key) {
        return insert(new RB_Node<T>(key));
    }

    public boolean removeRB(T key) {
        return remove(new RB_Node<T>(key));

    }


    private boolean insert(RB_Node<T> z) {


        RB_Node<T> y = nil;
        RB_Node<T> x = root;


        while (!isNil(x)) {
            y = x;


            if (z.key.compareTo(x.key) < 0) {


                x.numLeft++;
                x = x.left;
            } else if (z.key.compareTo(x.key) > 0) {


                x.numRight++;
                x = x.right;
            } else {
                return false;
            }
        }

        z.parent = y;


        if (isNil(y))
            root = z;
        else if (z.key.compareTo(y.key) < 0)
            y.left = z;
        else
            y.right = z;


        z.left = nil;
        z.right = nil;
        z.color = RB_Node.RED;


        insertFixup(z);
        return true;

    }


    private void insertFixup(RB_Node<T> z) {

        RB_Node<T> y = nil;

        while (z.parent.color == RB_Node.RED) {


            if (z.parent == z.parent.parent.left) {


                y = z.parent.parent.right;


                if (y.color == RB_Node.RED) {
                    z.parent.color = RB_Node.BLACK;
                    y.color = RB_Node.BLACK;
                    z.parent.parent.color = RB_Node.RED;
                    z = z.parent.parent;
                } else if (z == z.parent.right) {


                    z = z.parent;
                    leftRotate(z);
                } else {

                    z.parent.color = RB_Node.BLACK;
                    z.parent.parent.color = RB_Node.RED;
                    rightRotate(z.parent.parent);
                }
            } else {


                y = z.parent.parent.left;


                if (y.color == RB_Node.RED) {
                    z.parent.color = RB_Node.BLACK;
                    y.color = RB_Node.BLACK;
                    z.parent.parent.color = RB_Node.RED;
                    z = z.parent.parent;
                } else if (z == z.parent.left) {

                    z = z.parent;
                    rightRotate(z);
                } else {

                    z.parent.color = RB_Node.BLACK;
                    z.parent.parent.color = RB_Node.RED;
                    leftRotate(z.parent.parent);
                }
            }
        }

        root.color = RB_Node.BLACK;

    }


    public RB_Node<T> treeMinimum(RB_Node<T> node) {


        while (!isNil(node.left))
            node = node.left;
        return node;
    }

    public RB_Node<T> treeMaximum(RB_Node<T> node) {


        while (!isNil(node.right))
            node = node.right;
        return node;
    }


    public RB_Node<T> treeSuccessor(RB_Node<T> x) {


        if (!isNil(x.left))
            return treeMinimum(x.right);

        RB_Node<T> y = x.parent;


        while (!isNil(y) && x == y.right) {

            x = y;
            y = y.parent;
        }

        return y;
    }


    public boolean remove(RB_Node<T> v) {

        RB_Node<T> z = search(v.key);
        if (z == nil) {
            return false;
        }


        RB_Node<T> x = nil;
        RB_Node<T> y = nil;


        if (isNil(z.left) || isNil(z.right))
            y = z;


        else y = treeSuccessor(z);


        if (!isNil(y.left))
            x = y.left;
        else
            x = y.right;


        x.parent = y.parent;


        if (isNil(y.parent))
            root = x;


        else if (!isNil(y.parent.left) && y.parent.left == y)
            y.parent.left = x;


        else if (!isNil(y.parent.right) && y.parent.right == y)
            y.parent.right = x;


        if (y != z) {
            z.key = y.key;
        }


        fixNodeData(x, y);


        if (y.color == RB_Node.BLACK)
            removeFixup(x);
        return true;
    }


    private void fixNodeData(RB_Node<T> x, RB_Node<T> y) {


        RB_Node<T> current = nil;
        RB_Node<T> track = nil;


        if (isNil(x)) {
            current = y.parent;
            track = y;
        } else {
            current = x.parent;
            track = x;
        }


        while (!isNil(current)) {


            if (y.key != current.key) {


                if (y.key.compareTo(current.key) > 0)
                    current.numRight--;


                if (y.key.compareTo(current.key) < 0)
                    current.numLeft--;
            } else {


                if (isNil(current.left))
                    current.numLeft--;
                else if (isNil(current.right))
                    current.numRight--;


                else if (track == current.right)
                    current.numRight--;
                else if (track == current.left)
                    current.numLeft--;
            }


            track = current;
            current = current.parent;

        }

    }


    private void removeFixup(RB_Node<T> x) {

        RB_Node<T> w;


        while (x != root && x.color == RB_Node.BLACK) {


            if (x == x.parent.left) {


                w = x.parent.right;


                if (w.color == RB_Node.RED) {
                    w.color = RB_Node.BLACK;
                    x.parent.color = RB_Node.RED;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }


                if (w.left.color == RB_Node.BLACK &&
                        w.right.color == RB_Node.BLACK) {
                    w.color = RB_Node.RED;
                    x = x.parent;
                } else {

                    if (w.right.color == RB_Node.BLACK) {
                        w.left.color = RB_Node.BLACK;
                        w.color = RB_Node.RED;
                        rightRotate(w);
                        w = x.parent.right;
                    }

                    w.color = x.parent.color;
                    x.parent.color = RB_Node.BLACK;
                    w.right.color = RB_Node.BLACK;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {


                w = x.parent.left;


                if (w.color == RB_Node.RED) {
                    w.color = RB_Node.BLACK;
                    x.parent.color = RB_Node.RED;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }


                if (w.right.color == RB_Node.BLACK &&
                        w.left.color == RB_Node.BLACK) {
                    w.color = RB_Node.RED;
                    x = x.parent;
                } else {

                    if (w.left.color == RB_Node.BLACK) {
                        w.right.color = RB_Node.BLACK;
                        w.color = RB_Node.RED;
                        leftRotate(w);
                        w = x.parent.left;
                    }


                    w.color = x.parent.color;
                    x.parent.color = RB_Node.BLACK;
                    w.left.color = RB_Node.BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }


        x.color = RB_Node.BLACK;
    }


    public RB_Node<T> search(T key) {


        RB_Node<T> current = root;


        while (!isNil(current)) {


            if (current.key.equals(key))


                return current;


            else if (current.key.compareTo(key) < 0)
                current = current.right;


            else
                current = current.left;
        }


        return nil;


    }


    private boolean isNil(RB_Node node) {


        return node == nil;

    }


    @Override
    public boolean insert(Comparable data) {
        return insertRB((T) data);
    }

    @Override
    public boolean delete(Comparable data) {
        return removeRB((T) data);
    }

    @Override
    public void traverse() {
        if (root == nil) {
            return;
        }
        inOrderTraversal(root);


    }

    private void inOrderTraversal(RB_Node<T> node) {
        if (node != nil) {
            inOrderTraversal(node.left);
            System.out.println(node.key);
            inOrderTraversal(node.right);
        }

    }

    @Override
    public Comparable getMin() {
        return treeMinimum(root).key;
    }

    @Override
    public Comparable getMax() {
        return treeMaximum(root).key;
    }

    @Override
    public boolean contains(Comparable data) {
        RB_Node<T> node = search((T) data);
        if (node == nil) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return root == nil;
    }


    public int getSize() {
        if (root == nil) {
            return 0;
        }


        return root.numLeft + root.numRight + 1;
    }


    @Override
    public int getHeight() {
        if (root == nil) {
            return 0;
        }
        Queue<RB_Node> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0) {
                return height;
            }
            height++;
            while (nodeCount > 0) {
                RB_Node<T> node = queue.remove();
                if (node.left != nil) {
                    queue.add(node.left);
                }
                if (node.right != nil) {
                    queue.add(node.right);
                }
                nodeCount--;
            }
        }
    }
}