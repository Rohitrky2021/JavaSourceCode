package string;

public class sortdis {
    public static void main(String[] args) {
        String str = "WNEENESENNN";
        Float ans = sort_distance(str);
        System.out.println(ans);
    }

    public static Float sort_distance(String str) {
        int x=0,y=0;
        for(int i=0;i<str.length();i++){
            //north
            if(str.charAt(i)=='N'){
                y++;
            }
            if(str.charAt(i)=='S'){
                y--;
            }
            if(str.charAt(i)=='E'){
                x++;
            }
            if(str.charAt(i)=='W'){
                x--;
            }
        }

        return (float)Math.sqrt(x*x+y*y);
    }
}
