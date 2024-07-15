//WAP to implement block scope
public class blockscope {
    public static void main(String[] args) {
        {
            int s = 45;
            System.out.println("The value of variable s is: "+s);
        }
        //this means that in whichever block we declare the variable, only in that block we can declare it
    }
}
