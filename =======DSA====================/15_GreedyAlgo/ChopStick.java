import java.util.*;

// https://www.codingbroz.com/chopsticks-codechef-solution/

public class ChopStick { // o(Nlog(n))
    // Max Diff ==> D

    public static void main(String[] args) {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] chopsticks = new int[n];
        for (int i = 0; i < n; i++) {
            chopsticks[i] = sc.nextInt();
        }
        Arrays.sort(chopsticks);
        int chopsticksPair = 0;
        for (int i = 0; i < n - 1; i++) {
            if (chopsticks[i + 1] - chopsticks[i] <= d) {
                chopsticksPair++;
                i++;
            }
        }
        System.out.println(chopsticksPair);
    }

}

// Actually,

// the two
// sticks in
// a pair
// of chopsticks
// need not
// be of
// the same
// length.A pair
// of sticks
// can be
// used to
// eat as
// long as
// the difference
// in their
// length is
// at most
// D.The Chef
// has N
// sticks in
// which the
// ith stick is L[i]units long.
// A stick can’
// t be
// part of
// more than
// one pair
// of chopsticks.
// Help the
// Chef in
// pairing up
// the sticks
// to form
// the maximum
// number of
// usable pairs
// of chopsticks
// .