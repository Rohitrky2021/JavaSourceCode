//WAP to implement friend's pairing problem
public class friendspairingproblem {
    public static int friendspairing(int n) {
        //base case
        if(n == 1 || n == 2) {
            return n;
        }

        //the choices in this problem are:
        //1. single pairing
        int fnm1 = friendspairing(n-1);

        //2. pairing
        int fnm2 = friendspairing(n-2);
        int pairWays = (n-1) * fnm2;

        //total ways
        int totalways = fnm1 + pairWays;
        return totalways;
    }
    public static void main(String[] args) {
        System.out.println(friendspairing(3));
    }
}
