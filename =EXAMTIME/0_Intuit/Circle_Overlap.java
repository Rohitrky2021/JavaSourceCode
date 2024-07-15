// https://leetcode.com/discuss/interview-question/2416447/intuit

public class Circle_Overlap {

}

public class CircleOverlappingQuestion {

    public static class GraphNode {
        int node;
        Set<Integer> edges;

        public GraphNode(int node) {
            this.node = node;
            edges = new HashSet<>();
        }

        public void addEdge(int edgeNode) {
            edges.add(edgeNode);
        }

        public void removeEdge(int edgeNode) {
            edges.remove(edgeNode);
        }
    }

    public static int minimumCirclerequiredToRemoveToMakeItNonOverlapping(int[][] circleCoordinate) {

        List<GraphNode> nodes = new ArrayList<>();

        for (int i = 0; i < circleCoordinate.length; i++) {
            nodes.add(new GraphNode(i));
        }

        int connectedCirlces = 0;
        for (int i = 0; i < circleCoordinate.length; i++) {
            for (int j = i + 1; j < circleCoordinate.length; j++) {

                double distance = Math.sqrt(Math.pow(circleCoordinate[i][0] - circleCoordinate[j][0], 2)
                        + Math.pow(circleCoordinate[i][1] - circleCoordinate[j][1], 2));

                double distanceBetweenCircles = circleCoordinate[i][2] + circleCoordinate[j][2];

                if (distance <= distanceBetweenCircles) {
                    nodes.get(i).addEdge(j);
                    nodes.get(j).addEdge(i);
                    connectedCirlces += 1;
                }
            }
        }

        PriorityQueue<GraphNode> priorityQueue = new PriorityQueue<>((b, a) -> Integer.compare(a.edges.size(),
                b.edges.size()));

        for (int i = 0; i < nodes.size(); i++) {
            priorityQueue.add(nodes.get(i));
        }

      for (Integer connectedNode : graphNode.edges) {
              GraphNode theNode = nodes.get(connectedNode);
              priorityQueue.remove(theNode);
              theNode.removeEdge(graphNode.node);
              if (!theNode.edges.isEmpty()) {
                  priorityQueue.add(theNode);
              }
          }

        return circleCoordinate.length - priorityQueue.size();
    }

    public static void main(final String args[]) {
        int[][] circleCoordinates = {
                { 0, 0, 3 },
                { 2, 0, 3 },
                { 4, 0, 3 }
        };

        System.out.println(minimumCirclerequiredToRemoveToMakeItNonOverlapping(circleCoordinates));
    }
}

