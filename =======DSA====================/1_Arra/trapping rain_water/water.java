
public class water {
    public static void main(String args[]){
        int height[]={4,2,0,6,3,2,5};
        tp(height);

    }
    public static void tp(int xyz[]){
        //O(n)
        int tp=0;
        int n=xyz.length;
        int leftMax[]= new int [n]; 
        leftMax[0]=xyz[0];
        for (int i = 1; i < xyz.length; i++) {//--<More optimise way of it is using Stack 
            leftMax[i]=Math.max(xyz[i],leftMax[i-1]);
        }
        int Rmax[]=new int[n];
        Rmax[n-1]=xyz[n-1];
        for (int i = n-2; i>=0; i--) {
            Rmax[i]=Math.max(xyz[i],Rmax[i+1]);
            
        }
        for (int i = 0; i < Rmax.length; i++) {
            int waterLevel=Math.min(Rmax[i],leftMax[i]);
            tp+=(waterLevel-xyz[i]);
            System.out.println(waterLevel);
        }
        System.out.println("The trap water is :"+tp);

    }
    
}
