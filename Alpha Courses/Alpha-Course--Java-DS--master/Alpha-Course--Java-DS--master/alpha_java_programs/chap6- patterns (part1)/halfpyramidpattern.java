//WAP to print half pyramid pattern of numbers using nested loops
//print the following pattern
/*
 * 1
 * 12
 * 123
 * 1234
 */
public class halfpyramidpattern {
    public static void main(String[] args) {
        int n = 4;
        for(int line=1; line<=n; line++) {
            for(int number=1; number<=line; number++)
            {
                System.out.print(number);
            }
            System.out.println();
        }
    }
}
