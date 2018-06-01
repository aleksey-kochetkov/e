package e.grkalg;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;

public class WeightedGraph<T> {
    private Map<T, List<Edge>> map = new HashMap<>();

    public class Edge {
        private T vertice;
        private double weight;

        private Edge(T vertice, double weight) {
            this.vertice = vertice;
            this.weight = weight;
        }

        public T getVertice() {
            return vertice;
        }

        public double getWeight() {
            return weight;
        }
    }

    private void addEdge(T start, Edge finish) {
        List<Edge> list = map.computeIfAbsent(start,
                                              key -> new LinkedList<>());
        if (finish != null) {
            list.add(finish);
        }
    }

    public void addEdge(T start, T finish, double weight) {
        this.addEdge(start, new Edge(finish, weight));
    }

    public void addEdge(T finish) {
        this.addEdge(finish, null);
    }

    public List<Edge> getEdges(T vertice) {
        return map.get(vertice);
    }

    public Set<T> getAllVertices() {
        return map.keySet();
    }
}
