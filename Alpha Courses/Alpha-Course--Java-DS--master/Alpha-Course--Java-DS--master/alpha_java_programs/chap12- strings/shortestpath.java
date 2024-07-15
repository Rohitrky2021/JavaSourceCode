//WAP to find the shortest path of a string
public class shortestpath {
    public static float shortest(String path) {
        int x = 0;
        int y = 0;
        for(int i=0; i<path.length(); i++)
        {
            char dir = path.charAt(i);
            //south direction
            if(dir == 'S') {
                y--;
            }
            //north direction
            else if(dir == 'N') {
                y++;
            }
            //west direction
            else if(dir == 'W') {
                x--;
            }
            //east direction
            else if(dir == 'E') {
                x++;
            }
        }
        int X2 = x*x;
        int Y2 = y*y;
        return (float)Math.sqrt(X2 + Y2);
    }
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(shortest(path));
    }
}
