public class shortestpath {
    public static void main(String args[]){
        String dir="";
        System.out.println(shortestpath(dir)); 

    }
    public static float shortestpath(String xyx){
        int x=0,y=0,nx=0,ny=0;
        for (int i = 0; i < xyx.length(); i++) {
            char n=xyx.charAt(i);
            if(n=='E'){
                x++;
            }
            if(n=='W'){
                x--;
            }
            if(n=='N'){
                y++;
            }
            if(n=='S'){
                y--;
            }
        }

        return (float)Math.sqrt((x*x)+(y*y));
    }
}
