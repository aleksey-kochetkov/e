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
}
