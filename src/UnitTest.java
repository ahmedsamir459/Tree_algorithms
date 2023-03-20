
import org.junit.Test;
import static org.junit.Assert.*;
public class UnitTest {
    @Test
    public void testBinarySearchTree() {
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

//        assertEquals(20, avlTree.size());
//        assertEquals(5, avlTree.height());
//        assertEquals(1, (int) avlTree.getMin());
//        assertEquals(20, (int) avlTree.getMax());
        assertEquals(20, (int) avlTree.getRoot().getData());
//        assertTrue(avlTree.contains(10));
//        assertTrue(avlTree.contains(5));
//        assertTrue(avlTree.contains(15));
//        assertTrue(avlTree.contains(3));
//        assertTrue(avlTree.contains(7));
//        assertTrue(avlTree.contains(12));
//        assertTrue(avlTree.contains(18));
//        assertTrue(avlTree.contains(1));
//        assertTrue(avlTree.contains(4));
//        assertTrue(avlTree.contains(6));
//        assertTrue(avlTree.contains(8));
//        assertTrue(avlTree.contains(11));
//        assertTrue(avlTree.contains(13));
//        assertTrue(avlTree.contains(16));
//        assertTrue(avlTree.contains(19));
//        assertTrue(avlTree.contains(2));
//        assertTrue(avlTree.contains(9));
//        assertTrue(avlTree.contains(14));
//        assertTrue(avlTree.contains(17));
//        assertTrue(avlTree.contains(20));
//        assertFalse(avlTree.contains(0));
//        assertFalse(avlTree.contains(21));
//        avlTree.remove(10);
//        assertEquals(19, avlTree.size());
//        assertEquals(5, avlTree.height());
//        assertEquals(1, (int) avlTree.getMin());
//        assertEquals(20, (int) avlTree.getMax());
//        assertFalse(avlTree.contains(10));
//        assertTrue(avlTree.contains(5));
//        assertTrue(avlTree.contains(15));
//        assertTrue(avlTree.contains(3));
//        assertTrue(avlTree.contains(7));
//        assertTrue(avlTree.contains(12));
//        assertTrue(avlTree.contains(18));
//        assertTrue(avlTree.contains(1));
//        assertTrue(avlTree.contains(4));
//        assertTrue(avlTree.contains(6));
//        assertTrue(avlTree.contains(8));
//        assertTrue(avlTree.contains(11));
    }
}

