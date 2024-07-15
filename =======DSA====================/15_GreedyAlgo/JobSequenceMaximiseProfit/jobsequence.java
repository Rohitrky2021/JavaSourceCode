import java.util.*;

public class jobsequence {
    static class job{
        int deadline;
        int profit;
        int id;//0->A,1->B,2->C;

        public job(int i, int d,int p ){//constructor;
            id=i;
            deadline=d;
            profit=p;
    
        } 
        
    }
    public static void main(String args[]){
        int jobinfo[][]={{4,20},{1,10},{1,40},{1,30}};

        // job jobs[]=new job[jobinfo.length];  No need to define size now;

        ArrayList<job> jobs=new ArrayList<>();

        for (int i = 0; i < jobinfo.length; i++) {
        jobs.add(new job(i,jobinfo[i][0],jobinfo[i][1]));
           
        }

        Collections.sort(jobs, (obj1,obj2) ->obj2.profit-obj1.profit  /*lamda func*/);//learn this for descending order
        //comparing starts now

        ArrayList<Integer> seq=new ArrayList<>();
        int time=0;
        for (int i = 0; i < jobs.size(); i++) {
            job curr=jobs.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
                 
            }
        }

        System.out.println("Max jobs ="+ seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i)+" ");
        }



        
    }
}
