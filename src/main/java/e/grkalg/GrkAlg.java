package e.grkalg;

import java.util.Iterator;

public class GrkAlg {

  public static void selectionSort(int[] array) {
    int sorted = 0;
    while (sorted < array.length) {
      int lowI = sorted;
      for (int i = sorted; i < array.length; i++)
        if (array[i] < array[lowI])
          lowI = i;
      int tmp = array[sorted];
      array[sorted++] = array[lowI];
      array[lowI] = tmp;
    }
  }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = array[right];
            int bound = left;
            int tmp;
            for (int i = left; i < right; i++) {
                if (array[i] < pivot) {
                    tmp = array[bound];
                    array[bound++] = array[i];
                    array[i] = tmp;
                }
            }
            array[right] = array[bound];
            array[bound] = pivot;
            quickSort(array, left, bound - 1);
            quickSort(array, bound + 1, right);
        }
    }
}
