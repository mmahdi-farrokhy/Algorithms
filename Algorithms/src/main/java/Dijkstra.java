import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public class Dijkstra {
    @NonNull
    private final Map<String, Map<String, Integer>> graph;
    @NonNull
    private Map<String, Integer> costs;
    @NonNull
    private final Map<String, String> parents;
    private List<String> processed = new LinkedList<>();

    public int findShortestPathFromStartToFinish() {
        String node = findLowestCostNode(costs);

        while (node != null) {
            Integer cost = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);

            if (neighbors != null) {
                for (var n : neighbors.keySet()) {
                    int newCost = cost + neighbors.get(n);
                    if (costs.get(n) > newCost) {
                        costs.put(n, newCost);
                        parents.put(n, node);
                    }
                }
            }

            processed.add(node);
            node = findLowestCostNode(costs);
        }

        return costs.get("Finish");
    }

    private String findLowestCostNode(Map<String, Integer> costs) {
        String lowestCostNode = null;
        int lowestCost = Integer.MAX_VALUE;

        for (String node : costs.keySet()) {
            Integer cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }

        return lowestCostNode;
    }
}
