import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.Random;

public class StudentTest {

    @Test
    public void insertSmallBST() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] a = new int[]{4, 8, 0, 2, 6, 10};
        /*
         *       4
         *     /  \
         *    /    \
         *   0      8
         *    \    / \
         *     2  6   10
         */
        for (Integer key : a) {
            bst.insert(key);
            map.put(key, key);
        }
        for (int i = 0; i != 11; ++i) {
            assertEquals(bst.contains(i), map.containsKey(i));
        }
    }

        /**
     * TODO: Test cases
     */
    @Test
    public void test() {
        insertSmallBST();
        // your tests go here
    }

    /*
         Helper Methods to Validate AVL Property
     */
    private static int calc_height(BinarySearchTree.Node<Integer> n) {
        if (n == null) return -1;
        else return 1 + Math.max(calc_height(n.left), calc_height(n.right));
    }

    private static boolean validate_height(BinarySearchTree.Node<Integer> n) {
        if (n == null) return true;
        if (Math.abs(calc_height(n.left) - calc_height(n.right)) > 1) return false;
        return validate_height(n.left) && validate_height(n.right);
    }

    private static void validate_height(BinarySearchTree<Integer> avl) {
        assertTrue(validate_height((BinarySearchTree.Node<Integer>) avl.root));
    }
}
