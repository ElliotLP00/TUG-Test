import graph.SimpleGraph;

public class plotter {
     public static void main(String[] args) {
        new plotter();
     }

    public plotter() {
        SimpleGraph graph = new SimpleGraph();
        graph.display();
        for(int i = 0; i<15; i++){
            graph.addPoint(i,i);
        }
    }
}