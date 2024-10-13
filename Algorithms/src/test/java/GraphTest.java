import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphTest {
    private Map<String, List<Connection>> connections;
    private Graph graph;

    @BeforeEach
    void setUp() {
        connections = new LinkedHashMap<>();
        connections.put("You", List.of(new Connection("Bob", 1), new Connection("Clarie", 1), new Connection("Alice", 1)));
        connections.put("Bob", List.of(new Connection("Anuj", 2), new Connection("Peggy", 2)));
        connections.put("Alice", List.of(new Connection("Peggy", 2)));
        connections.put("Clarie", List.of(new Connection("Tom", 2), new Connection("Jonny", 2)));

        graph = new Graph(connections);
    }

    @Test
    void tell_if_there_is_mango_seller_in_the_connections() {
        assertTrue(graph.isThereAMangoSellerInConnection());
    }

    @Test
    void find_the_shortest_distance_to_a_mango_seller_in_connections() {
        assertEquals(2, graph.findShortestDistanceToMangoSeller());
    }
}
