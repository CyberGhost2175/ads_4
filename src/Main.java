public class Main {
    public static void main(String[] args) {

        MyGraph<String> graph = new MyGraph<>();

        graph.addVertex("Astana");
        graph.addVertex("Almaty");
        graph.addVertex("Petropavlovsk");
        graph.addVertex("Pavlodar");
        graph.addVertex("Shymkent");
        graph.addVertex("Atyray");

        graph.addEdge("Astana", "Almaty");
        graph.addEdge("Karaganda", "Astana");
        graph.addEdge("Semey", "Shymkent");
        graph.addEdge("Petropavlovsk", "Semey");
        graph.addEdge("Shymkent", "Pavlodar");

        System.out.println(graph.hasEdge("Astana", "Shymkent"));
        System.out.println(graph.hasEdge("Astana", "Almaty"));
        System.out.println(graph.hasEdge("Karaganda", "Pavlodar"));
    }
}