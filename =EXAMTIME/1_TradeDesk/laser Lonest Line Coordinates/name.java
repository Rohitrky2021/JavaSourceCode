import java.util.ArrayList;
import java.util.List;

public class name {  // Tested Working 

    public static boolean isSafe(int r, int c, List<List<Integer>> laser) {
        for (List<Integer> l : laser) {
            int lr = l.get(0);
            int lc = l.get(1);
            if (r == lr || c == lc) {
                return false;
            }
        }
        return true;
    }

    public static int lsp(int nr, int nc, int cr, int cc, List<List<Integer>> laser) {
        int mpl = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] d : dirs) {
            int nrw = cr + d[0];
            int ncl = cc + d[1];
            int pl = 0;

            while (nrw >= 1 && nrw <= nr && ncl >= 1 && ncl <= nc && isSafe(nrw, ncl, laser)) {
                pl++;
                nrw += d[0];
                ncl += d[1];
            }
            mpl = Math.max(mpl, pl);
        }
        return mpl;
    }

    public static void main(String[] args) {
        int n = 8;
        int m = 8;
        List<List<Integer>> laserCoordinates = new ArrayList<>();
        laserCoordinates.add(List.of(1, 6));
        laserCoordinates.add(List.of(2, 8));

        int currow = 5;
        int curcol = 3;

        int result = lsp(n, m, currow, curcol, laserCoordinates);
        System.out.println("Maximum length of a straight line passing through the current cell: " + result);
    }
}
