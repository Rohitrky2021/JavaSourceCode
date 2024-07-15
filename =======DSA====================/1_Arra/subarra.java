public class subarra {
    public static void main(String args[]){
        int marks[]={1,2,3};
        System.out.println("ur  values are");
        for(int i=0;i<marks.length;i++)
        System.out.print(marks[i]+" ");
        System.out.println();
        pairs(marks);


    
        
    }
    public static void pairs(int marks[]){
        int count=0,mc=0,ans=0;
        for(int i=0;i<marks.length;i++){
            int current=marks[i];
            for(int j=0;j<marks.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(marks[k]);
                    mc++;
                    ans+=Math.abs(marks[i]-marks[j]);

                }
                System.out.print(" " );
                // System.out.print(mc);

               count++;
            }
            System.out.print("" );


        }
        System.out.println(ans/2);
}
}
