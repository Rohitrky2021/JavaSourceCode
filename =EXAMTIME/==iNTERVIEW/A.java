import java.util.*;

class A {
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        // Commenting out equals and hashCode methods
         
        // @Override
        // public boolean equals(Object o) {
        //     if (this == o) return true;
        //     if (o == null || getClass() != o.getClass()) return false;
        //     Pair pair = (Pair) o;
        //     return first == pair.first && second == pair.second;
        // }

        // @Override
        // public int hashCode() {
        //     return Objects.hash(first, second);
        // }
     
    }

    public static int minTime(int n, int m, int[][] matrix) {
        HashSet<Pair> hs = new HashSet<>();
        
        hs.add(new Pair(1, 1));
        hs.add(new Pair(1, 1));
        
        System.out.println(hs.size());
        
        return 0;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[0][0];
        minTime(0, 0, matrix);
    }
}
