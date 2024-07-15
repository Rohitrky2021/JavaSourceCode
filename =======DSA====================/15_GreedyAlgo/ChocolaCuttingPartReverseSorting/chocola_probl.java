import java.util.*;
public class chocola_probl {

    public static void main(String args[]){
        int n=4,m=6;
        Integer cosVer[]={2,1,3,1,4};
        Integer coshor[]={4,1,2};
    
        Arrays.sort(cosVer,Collections.reverseOrder());
        Arrays.sort(coshor,Collections.reverseOrder());

        int h=0,v=0;
        int hp=1,vp=1;
        int cost=0;
    
        while(h< coshor.length && v< cosVer.length){
            if(cosVer[v]<=coshor[h]){//horixontal cut
                cost+=(coshor[h]*vp);
                hp++;
                h++;
            }
            else{//vertical cut
                cost+=(cosVer[v]*hp);
                vp++;
                v++;
            }
        }
            while(v<cosVer.length){
                cost+=(cosVer[v]*hp);
                vp++;
                v++;
            }
            
            while(v<coshor.length){
                cost+=(coshor[h]*vp);
                hp++;
                h++;
            }
            System.out.println(cost);
        }
    }

