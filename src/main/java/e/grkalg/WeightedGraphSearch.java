package e.grkalg;

//import e.Output;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class WeightedGraphSearch<T> {
    private WeightedGraph<T> graph;

    private class Calculated {
        T parent = null;
        double cost = -1;
        boolean processed = false;
    }

    private Map<T, Calculated> calculated;

    public WeightedGraphSearch(WeightedGraph<T> graph) {
        this.graph = graph;
    }

    public List<T> cheepestWaySearch(T start, T finish) {
        this.init();
        this.calculated.get(start).cost = 0;
        this.fillCosts();
        return this.createWay(start, finish);
    }

    public double wayCost(T finish) {
        return calculated.get(finish).cost;
    }

    private void init() {
        this.calculated = new HashMap<>();
        for (T v : graph.getAllVertices()) {
            calculated.put(v, new Calculated());
        }
    }

    private T findCheepest() {
        boolean found = false;
        double cost = 0;
        T result = null;
        for(Map.Entry<T, Calculated> entry : calculated.entrySet()) {
            if (!entry.getValue().processed && entry.getValue().cost > -1
              && (!found || cost > entry.getValue().cost)) {
                cost = entry.getValue().cost;
                result = entry.getKey();
                found = true;
            }
        }
        return result;
    }

    private void fillCosts() {
        T current;
        while ((current = findCheepest()) != null) {
            for (WeightedGraph<T>.Edge edge : graph.getEdges(current)) {
                double newCost = calculated.get(current).cost + edge.getWeight();
                if (calculated.get(edge.getVertice()).cost == -1
                        || newCost < calculated.get(edge.getVertice()).cost) {
                    calculated.get(edge.getVertice()).cost = newCost;
                    calculated.get(edge.getVertice()).parent = current;
                }
            }
            calculated.get(current).processed = true;
        }
    }

    private List<T> createWay(T start, T finish) {
        List<T> way = new LinkedList<>();
        T current = finish;
        do {
            way.add(current);
            current = calculated.get(current).parent;
        } while (current != null);
        return way;
    }
}
