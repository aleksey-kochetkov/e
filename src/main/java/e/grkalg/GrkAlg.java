package e.grkalg;

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
  
}
