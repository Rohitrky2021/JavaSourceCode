import java.util.PriorityQueue;
public class near {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distance;
        int idx;
        public Point(int x, int y , int distance,int idx){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.idx =idx; 
        }
        @Override 
        public int compareTo(Point p2){
            return this.distance - p2.distance; //ascending order sorting
        }
    }
    public static void main(String[] args) {
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k=2;
        PriorityQueue<Point>  pq = new PriorityQueue<>();
        for(int i =0 ;i<pts.length;i++ ){
            int sq  = (pts[i][0])^2 + (pts[i][1])^2;
            pq.add(new Point(pts[i][0],pts[i][1], sq,i));
        }

        for(int i=0;i<k ;i++){
            System.out.println("C" + pq.remove().idx);
        }
    }
}
