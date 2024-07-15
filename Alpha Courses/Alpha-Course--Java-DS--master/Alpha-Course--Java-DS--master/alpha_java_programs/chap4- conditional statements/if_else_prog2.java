//prog on if-else to check if a person is an adult or a teenager
public class if_else_prog2 {
    public static void main(String[] args) {
        int age = 16;
        if(age >=18) 
        {
            System.out.println("you are an adult");
        }
        if(age>13 && age<18)
        {
            System.out.println("you are a teenager");
        }
        else 
        {
            System.out.println("you are not an adult");
        }
    }
}
/*
 * Explanation-
 * in this prog if the age is greater than 18 then it prints the person is an adult, if the age is greater than 13 and less than 18 
 * then the person is teenager or else the person is not an adult
 */