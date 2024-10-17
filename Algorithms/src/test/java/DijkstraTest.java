import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DijkstraTest {
    private Map<String, Map<String, Integer>> graph;
    private Map<String, Integer> costs;
    private Map<String, String> parents;

    @BeforeEach
    void setUp() {
        graph = new LinkedHashMap<>();
        graph.put("Start", new LinkedHashMap<>() {{
            put("A", 6);
            put("B", 5);
        }});

        graph.put("A", new LinkedHashMap<>() {{
            put("Finish", 1);
        }});

        graph.put("B", new LinkedHashMap<>() {{
            put("A", 3);
            put("Finish", 5);
        }});

        graph.put("Finish", null);

        costs = new LinkedHashMap<>();
        costs.put("A", 6);
        costs.put("B", 2);
        costs.put("Finish", Integer.MAX_VALUE);

        parents = new LinkedHashMap<>();
        parents.put("A", "Start");
        parents.put("B", "Start");
        parents.put("Finish", null);
    }

    @Test
    void fina_the_shortest_path_from_start_to_finish_node_in_a_weighted_graph() {
        Dijkstra dijkstra = new Dijkstra(graph, costs, parents);
        int shortestPathFromStartToFinish = dijkstra.findShortestPathFromStartToFinish();
        Map<String, String> parentsAfterAlgorithm = dijkstra.getParents();
        Map<String, Integer> costsAfterAlgorithm = dijkstra.getCosts();
        List<String> processedAfterAlgorithm = dijkstra.getProcessed();

        for (String node : parentsAfterAlgorithm.keySet()) {
            System.out.println(parentsAfterAlgorithm.get(node) + " is parent of " + node);
        }

        System.out.println("***********************************");

        for (String node : costsAfterAlgorithm.keySet()) {
            System.out.println(costsAfterAlgorithm.get(node) + " is cost of " + node);
        }

        System.out.println("***********************************");

        for (String node : processedAfterAlgorithm) {
            System.out.println(node + " is a processed node");
        }

        Assertions.assertEquals(6, shortestPathFromStartToFinish);
    }
}
