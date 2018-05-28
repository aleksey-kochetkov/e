package e.grkalg;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import e.Output;

public class GrkAlgTest {

  @Test
  public void whenSelectionSort() {
    int[] input = {7, 3, 5, 1, 4, 2, 9, 8, 6, 0};
    int[] expect = {0, 1, 2, 3, 4, 5, 6, 7 , 8, 9};
    GrkAlg.selectionSort(input);
    assertThat(input, is(expect));
  }

  @Test
  public void whenTmp() {
    Output.println("Текст кириллицей");
  }
}
