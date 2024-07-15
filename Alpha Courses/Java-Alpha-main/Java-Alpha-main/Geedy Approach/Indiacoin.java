public class Indiacoin {
    public static void main(String[] args) {
        int denomination[] = {1,2,5,10,20,50,100,500,2000};
        int val = 590;
        int ans=0;
        for(int i= denomination.length -1 ; i >= 0 ; ){
            if(val==0){
                break;
            }
            if(val >= denomination[i]){
                val -= denomination[i];
                ans++;
            }else{
                i--;
            }
        }
        System.out.println(ans);
    }
}
