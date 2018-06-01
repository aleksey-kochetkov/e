package e.grkalg;

import e.Output;
import java.util.Queue;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

public class GrkAlg {

    public static void main(String[] args) {
//        graphDemo();
        weightedGraphDemo();
    }

    private static void graphDemo() {
        Output.println("Graph demo");
        Graph<String> graph = new Graph<>();
        graph.addEdge("you", "alice", "bob", "clair");
        graph.addEdge("bob", "anuj", "peggy");
        graph.addEdge("alice", "peggy");
        graph.addEdge("clair", "thom", "jonny");
        graph.addEdge("anuj");
        graph.addEdge("peggy");
        graph.addEdge("thom");
        graph.addEdge("jonny");
        Queue<String> vertices = new LinkedList<>(graph.getEdgesList("you"));
        while (!vertices.isEmpty()) {
            String v = vertices.remove();
            if (salesMango(v)) {
                Output.format("%s sales mango.", v);
                Output.println();
                break;
            }
            vertices.addAll(graph.getEdgesList(v));
        }
    }

    private static void weightedGraphDemo() {
        WeightedGraph<String> graph = new WeightedGraph<>();
        String start = "book";
        String finish = "piano";
        graph.addEdge(start, "poster", 0);
        graph.addEdge(start, "disk", 5);
        graph.addEdge("poster", "bass", 30);
        graph.addEdge("poster", "drum", 35);
        graph.addEdge("disk", "bass", 15);
        graph.addEdge("disk", "drum", 20);
        graph.addEdge("bass", finish, 20);
        graph.addEdge("drum", finish, 10);
        graph.addEdge(finish);
        WeightedGraphSearch<String> search = new WeightedGraphSearch<>(graph);
        List<String> way = search.cheepestWaySearch(start, finish);
        for (String s : way) {
            Output.format("%s<-", s);
        }
        Output.println();
        Output.format("%s cost:%f", finish, search.wayCost(finish));
    }

    public static int binarySearch(int[] array, int value) {
        int result = -1;
        int left = 0;
        int right = array.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (array[mid] == value) {
                result = mid;
                break;
            }
            if (value < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

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

    private static boolean salesMango(String name) {
        return name.charAt(name.length() - 1) == 'm';
    }

    public static <T> T breadthFirstSearch(Graph<T> graph, T start,
                                                Predicate<T> predicate) {
        T result = null;
        Queue<T> queue = new LinkedList<>(graph.getEdgesList(start));
        Set<T> checked = new HashSet<>();
        while (!queue.isEmpty()) {
            T v = queue.remove();
            if (checked.contains(v)) {
                continue;
            }
            checked.add(v);
            if (predicate.test(v)) {
                result = v;
                break;
            }
            queue.addAll(graph.getEdgesList(v));
        }
        return result;
    }
}
