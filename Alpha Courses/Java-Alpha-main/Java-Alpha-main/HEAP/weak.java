import java.util.PriorityQueue;
public class weak {
    static class Row implements Comparable<Row>{
        int soldier;
        int idx;
        public Row(int soldier,int idx){
            this.soldier =soldier;
            this.idx=idx;
        }
        @Override 
        public int compareTo(Row r2){
            if(this.soldier == r2.soldier){
                return this.idx-r2.idx;
            }else{
                return this.soldier-r2.soldier;
            }
        }
    }
    public static void main(String[] args) {
        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};
        int k=2;
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i=0 ; i < army.length;i++){
            int c=0;
            for(int j =0 ; i < army[0].length ;i++){
                c += army[i][j] == 1 ? 1:0;
                pq.add(new Row(c, i));
            }
        }
        for(int i =0 ; i < k ; i++){
            System.out.println("R"+pq.remove().idx);
        }

    }
}
