// WAP to implement tower of hanoi
public class exercise5 {
    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if(n == 1) {
            System.out.println("transfer disk" + n + "from" + src + "to" + dest);
            return;
        }

        //transfer top n-1 from src to helper using dest as helper
        towerOfHanoi(n-1, src, helper, dest);
        //transfer nth from src to dest
        System.out.println("transfer disk" + n + "from" + src + "to" + helper);
        //tranfer n-1 from helper to dest using src as helper
        towerOfHanoi(n-1, src, helper, dest);
    }
    public static void main(String[] args) {
        int n = 4;
        towerOfHanoi(n, "A", "B", "C");
    }
}
