package Trees;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
public class UnitTest {
    @Test
    public void testAvlTree() {
        ITree<Integer> avlTree = new AvlTree<Integer>();
        avlTree.insert(10);
        avlTree.insert(5);
        avlTree.insert(15);
        avlTree.insert(3);
        avlTree.insert(7);
        avlTree.insert(12);
        avlTree.insert(18);
        avlTree.insert(1);
        avlTree.insert(4);
        avlTree.insert(6);
        avlTree.insert(8);
        avlTree.insert(11);
        avlTree.insert(13);
        avlTree.insert(16);
        avlTree.insert(19);
        avlTree.insert(2);
        avlTree.insert(9);
        avlTree.insert(14);
        avlTree.insert(17);
        avlTree.insert(20);

        assertEquals(20, avlTree.size());
        assertEquals(5, avlTree.height());
        assertEquals(1, (int) avlTree.getMin());
        assertEquals(20, (int) avlTree.getMax());
        assertThrows(IllegalArgumentException.class, () -> avlTree.insert(20));
//        testbalnce(avlTree.getRoot());
    }
    @Test
    public void testRedBlackTree() {
        ITree<Integer> rbTree = new RedBlackTree<Integer>();
        rbTree.insert(10);
        rbTree.insert(5);
        rbTree.insert(15);
        rbTree.insert(3);
        rbTree.insert(7);
        rbTree.insert(12);
        rbTree.insert(18);
        rbTree.insert(1);
        rbTree.insert(4);
        rbTree.insert(6);
        rbTree.insert(8);
        rbTree.insert(11);
        rbTree.insert(13);
        rbTree.insert(16);
        rbTree.insert(19);
        rbTree.insert(2);
        rbTree.insert(9);
        rbTree.insert(14);
        rbTree.insert(17);
        rbTree.insert(20);
        assertEquals(20, rbTree.size());
        assertEquals(5, rbTree.height());
        assertEquals(1, (int) rbTree.getMin());
        assertEquals(20, (int) rbTree.getMax());
        testBlackHight(rbTree.getRoot(),0,0);
    }
    private void testBlackHight(Node <Integer> node, int blackHight, int currentBlackHight) {

        if (node == null) {
            if (blackHight == 0) {
                blackHight = currentBlackHight;
            } else {
                try {
                    assertEquals(blackHight, currentBlackHight);
                } catch (AssertionError e) {
                    throw new AssertionError(
                            "Black height is not equal on all paths (blackHeightFirstPath ="
                                    + blackHight+ "; blackHeightThisPath = "
                                    + currentBlackHight
                                    + ")");
                }
            }
            return;
        }
        if (node.getColor() == Color.BLACK) {
            currentBlackHight++;
        }
        else if(node.getParent()!=null && node.getParent().getColor()==Color.RED){
            fail("Red node has red parent");
        }
        testBlackHight(node.getLeft(), blackHight, currentBlackHight);
        testBlackHight(node.getRight(), blackHight, currentBlackHight);
    }

    void testbalnce(Node <Integer> node) {
        if (node == null) {
            return;
        }
        try {
            int h1 = node.getLeft() == null ? 0 : node.getLeft().getHeight();
            int h2 = node.getRight() == null ? 0 : node.getRight().getHeight();
            assertEquals(1, Math.abs(h1 - h2));
        } catch (AssertionError e) {
            int h1 = node.getLeft() == null ? 0 : node.getLeft().getHeight();
            int h2 = node.getRight() == null ? 0 : node.getRight().getHeight();
            assertEquals(0, Math.abs(h1 - h2));
        }
        testbalnce(node.getLeft());
        testbalnce(node.getRight());
    }
}

