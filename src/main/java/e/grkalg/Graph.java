package e.grkalg;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class Graph<T> {
    private Map<T, List<T>> map = new HashMap<>();

    @SafeVarargs
    public final void addEdge(T a, T... vertices) {
        List<T> list = this.map.get(a);
        if (list == null) {
            list = new LinkedList<>();
            map.put(a, list);
        }
        list.addAll(Arrays.asList(vertices));
    }

    public List<T> getEdgesList(T vertice) {
        return map.get(vertice);
    }
}
