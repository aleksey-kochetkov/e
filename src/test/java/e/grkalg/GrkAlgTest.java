package e.grkalg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import e.Output;
import java.util.List;
import java.util.Arrays;

public class GrkAlgTest {

    @Test
    public void whenBinarySearch() {
        int[] input = {1, 1, 2, 2, 3, 3, 3, 4, 5, 5};
        int result = GrkAlg.binarySearch(input, 4);
        assertEquals(7, result);
    }

    @Test
    public void whenBinarySearchNotFound() {
        int[] input = {1, 1, 2, 2, 3, 3, 3, 4, 5, 5};
        int result = GrkAlg.binarySearch(input, 6);
        assertEquals(-1, result);
    }

    @Test
    public void whenSelectionSort() {
      int[] input = {7, 3, 5, 1, 4, 2, 9, 8, 6, 0};
      int[] expect = {0, 1, 2, 3, 4, 5, 6, 7 , 8, 9};
      GrkAlg.selectionSort(input);
      assertThat(input, is(expect));
    }

    @Test
    public void whenQuickSort() {
        int[] array = {1, 2, 13, 2, 2, 3, 11, 3, 3, 14, 1, 1};
        int[] expect = {1, 1, 1, 2, 2, 2, 3, 3, 3, 11, 13, 14};
        GrkAlg.quickSort(array, 0, array.length - 1);
        assertThat(array, is(expect));
    }

    @Test
    public void whenBreadthFirstSearch() {
        Graph<String> graph = new Graph<>();
        graph.addEdge("One", "Two", "Three", "Four");
        graph.addEdge("Two", "Five", "Six");
        graph.addEdge("Three", "One");
        graph.addEdge("Four");
        graph.addEdge("Five");
        graph.addEdge("Six", "Seven");
        graph.addEdge("Seven");
        String result = GrkAlg.breadthFirstSearch(graph, "One",
                                                        "Seven"::equals);
        assertThat(result, is("Seven"));
    }
}
