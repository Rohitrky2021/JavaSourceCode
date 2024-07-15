import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read input values
        int n = input.nextInt(); // Number of people in "Bones"
        int m = input.nextInt(); // Number of people in "Blood"
        int x = input.nextInt(); // Treats handed out by each person in "Bones"
        int y = input.nextInt(); // Treats handed out by each person in "Blood"

        // Calculate the total number of treats
        int treatsFromBones = n * x;
        int treatsFromBlood = m * y;
        int totalTreats = treatsFromBones + treatsFromBlood;

        // Print the result
        System.out.println(totalTreats);

        input.close();
    }
}
