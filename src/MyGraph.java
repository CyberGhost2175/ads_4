import javax.management.openmbean.InvalidKeyException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Vertex>> adjacencyMap = new HashMap<>();

    public MyGraph() {
        this(true);
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        adjacencyMap.putIfAbsent(v, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) addVertex(source);
        if (!hasVertex(dest)) addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest)) return;

        adjacencyMap.get(source).add(dest);

        if (undirected) {
            adjacencyMap.get(dest).add(source);
        }
    }

    public int getVerticesCount() {
        return adjacencyMap.size();
    }

    public boolean hasVertex(Vertex v) {
        return adjacencyMap.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source) || !hasVertex(dest)) return false;
        return adjacencyMap.get(source).contains(dest);
    }

    public List<Vertex> getNeighbours(Vertex v) {
        if (!hasVertex(v)) throw new InvalidKeyException();
        return adjacencyMap.get(v);
    }

    public void removeVertex(Vertex v) {
        if (!hasVertex(v)) throw new InvalidKeyException();

        adjacencyMap.get(v).forEach(neighbour -> adjacencyMap.get(neighbour).remove(v));
        adjacencyMap.remove(v);
    }

    public void removeEdge(Vertex source, Vertex dest) {
        if (!hasEdge(source, dest)) return;

        adjacencyMap.get(source).remove(dest);

        if (undirected) {
            adjacencyMap.get(dest).remove(source);
        }
    }

    public Iterable<Vertex> getVertices() {
        return adjacencyMap.keySet();
    }


}
