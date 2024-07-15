package T18_Graphs;

public class G20_floodFill {

    public static int[][] floodFill(int image[][], int sr, int sc, int color) {

        boolean vis[][] = new boolean[image.length][image[0].length];

        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public static void helper(int image[][], int sr, int sc, int color, boolean vis[][], int orgCol) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }
        image[sr][sc] = color;
        helper(image, sr + 1, sc, color, vis, orgCol);
        helper(image, sr - 1, sc, color, vis, orgCol);
        helper(image, sr, sc + 1, color, vis, orgCol);
        helper(image, sr, sc - 1, color, vis, orgCol);
    }

    static void printImage(int image[][]) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int image[][] = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };
        int sr = 1;
        int sc = 1;
        int color = 2;
        printImage(image);
        floodFill(image, sr, sc, color);
        printImage(image);

    }
}
