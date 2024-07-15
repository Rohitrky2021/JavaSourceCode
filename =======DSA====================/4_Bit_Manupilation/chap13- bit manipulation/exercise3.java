//WAP to convert uppercase to lowercase letters using bit manipulation
public class exercise3 {
    public static void main(String[] args) {
        //convert uppercase character to lowercase
        for(char ch = 'A'; ch<= 'Z'; ch++)
        {
            System.out.print((char)(ch | ' '));
            //prints abcdefghijklmnopqrstuvwxyz
        }
    }
}
