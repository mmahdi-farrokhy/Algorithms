import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<String, List<Connection>> connections;

    public Graph(Map<String, List<Connection>> connections) {
        this.connections = connections;
    }

    public boolean isThereAMangoSellerInConnection() {
        boolean result = false;
        List<Connection> nodes = new LinkedList<>(connections.get("You"));

        for (int nodeIndex = 0; nodeIndex < nodes.size(); nodeIndex++) {
            Connection connection = nodes.get(nodeIndex);

            if (connection.isMangoSeller()) {
                result = true;
                break;
            } else {
                List<Connection> nextLevelConnections = connections.get(connection.getName());

                if (nextLevelConnections != null && !nextLevelConnections.isEmpty()) {
                    for (Connection nextLevelConnection : nextLevelConnections) {
                        if (!nodes.contains(nextLevelConnection)) {
                            nodes.add(nextLevelConnection);
                        }
                    }
                }
            }
        }

        return result;
    }

    public int findShortestDistanceToMangoSeller() {
        int shortestDistance = -1;

        List<Connection> nodes = new LinkedList<>(connections.get("You"));

        for (int nodeIndex = 0; nodeIndex < nodes.size(); nodeIndex++) {
            Connection connection = nodes.get(nodeIndex);

            if (connection.isMangoSeller()) {
                shortestDistance = connection.getLevel();
                break;
            } else {
                List<Connection> nextLevelConnections = connections.get(connection.getName());

                if (nextLevelConnections != null && !nextLevelConnections.isEmpty()) {
                    for (Connection nextLevelConnection : nextLevelConnections) {
                        if (!nodes.contains(nextLevelConnection)) {
                            nodes.add(nextLevelConnection);
                        }
                    }
                }
            }
        }

        return shortestDistance;
    }
}
