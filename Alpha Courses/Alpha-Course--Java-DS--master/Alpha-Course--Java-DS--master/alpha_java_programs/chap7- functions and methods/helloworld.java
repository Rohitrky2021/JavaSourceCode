//WAP to print hello world by making a seperate function for hello world and calling it in the main function
public class helloworld {
    public static void printhelloworld() {
        System.out.println("hello world");
        return;
    }
    public static void main(String[] args) {
        printhelloworld(); //function to call the above function and to print hello world in the output
    }
}
/*
 * Explanation-
 * if we don't call the above function in the main function then whatever we 
 * write in the other functions will not be printed in the output
 */