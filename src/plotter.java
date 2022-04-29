/*import graph.SimpleGraph;

import java.util.Vector;

public class plotter {
    private SimpleGraph graph;
    public static void main(String[] args) {
        new plotter();
    }

    public plotter() {
        graph = new SimpleGraph();
    }
    public void displayGraph(Vector<CSVMotionData> csvMotionDataVector){
        for (CSVMotionData c: csvMotionDataVector) {
            if(c.relativeTimeStamp != null){
                System.out.println((c.relativeTimeStamp.getTime()-csvMotionDataVector.get(1).relativeTimeStamp.getTime())/1000);
                graph.addPoint((Double.parseDouble(String.valueOf(c.relativeTimeStamp.getTime()-csvMotionDataVector.get(1).relativeTimeStamp.getTime())))/1000, c.sqrtModule/1000);
            }
            System.out.println(c.sqrtModule);
        }
        graph.display();
    }
}
*/