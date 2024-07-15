import java.util.*;
public class Job {
    public static void main(String[] args) {
        int jobs[][] ={{2,100,0},{1,19,1},{2,27,2},{1,25,3},{3,15,4}};
        //sort 
        Arrays.sort(jobs,Comparator.comparingDouble(o->o[1]));

        Queue<Character> ans = new LinkedList<>();
        int profit=0;
        int time =0;
        for(int i = jobs.length-1 ; i >= 0 ; i--){
            if(jobs[i][0] > time){
                profit += jobs[i][1]; 
                ans.add((char)(65+jobs[i][2]));
                time++;        
            }
      }
      System.out.println(profit);
      while(!ans.isEmpty()){
        System.out.print(ans.peek()+" ");
        ans.remove();
      }
      System.out.println();
    }
}
