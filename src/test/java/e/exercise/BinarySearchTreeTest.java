package e.exercise;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BinarySearchTreeTest {

    @Test
    public void whenEmpty() {
        BinarySearchTree tree = new BinarySearchTree();
        int[] expect = new int[0];
        assertThat(tree.toArray(), is(expect));
    }

    @Test
    public void whenAddThree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(2);
        tree.add(3);
        tree.add(1);
        int[] expect = {1, 2, 3};
        assertThat(tree.toArray(), is(expect));
    }

    @Test
    public void whenParentKey() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(2);
        tree.add(4);
        tree.add(1);
        tree.add(5);
        tree.add(3);
        tree.add(6);
        assertEquals(4, tree.parentKey(5));
    }
}
