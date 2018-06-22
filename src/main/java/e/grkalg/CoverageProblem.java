package e.grkalg;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Найти минимальный набор подмножеств полностью покрывающих заданное
 * множество.
 */
public class CoverageProblem<E, K> {
    private Set<E> set;
    private Map<K, Set<E>> subsets = new HashMap<>();

    public CoverageProblem(Set<E> set) {
        this.set = set;
    }

    public void addSubset(K key, Set<E> subset) {
        this.subsets.put(key, subset);
    }

    public Set<E> getSubset(K key) {
        return this.subsets.get(key);
    }

    public Set<K> getResult() {
        Set<K> result = new HashSet<>();
        Set<E> uncovered = new HashSet<>(this.set);
        Map<K, Set<E>> unused = new HashMap<>(this.subsets);
        K maxUnionSizeKey;
        do {
            int maxUnionSize = 0;
            maxUnionSizeKey = null;
            for (Map.Entry<K, Set<E>> entry : unused.entrySet()) {
                Set<E> tmp = new HashSet<>(uncovered);
                tmp.retainAll(entry.getValue());
                int unionSize = tmp.size();
                if (unionSize > maxUnionSize) {
                    maxUnionSizeKey = entry.getKey();
                    maxUnionSize = unionSize;
                }
            }
            if (maxUnionSizeKey != null) {
                result.add(maxUnionSizeKey);
                uncovered.removeAll(unused.get(maxUnionSizeKey));
                unused.remove(maxUnionSizeKey);
            }
        } while (uncovered.size() > 0 && unused.size() > 0
                                             && maxUnionSizeKey != null);
        return result;
    }
}
