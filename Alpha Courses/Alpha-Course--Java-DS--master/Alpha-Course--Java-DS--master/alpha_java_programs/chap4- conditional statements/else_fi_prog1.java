//prog on else-if to check if a person is adult, teenager or child
public class else_fi_prog1 {
    public static void main(String[] args) {
        int age = 13;
        if(age>=18) {
            System.out.println("adult");
        }
        else if(age>=13 && age<18) {
            System.out.println("teenager");
        }
        else {
            System.out.println("child");
        }
    }
}
/*
 * Explanation-
 * in the prog if age is greater than 18 then the person is adult
 * if the age is greater than 13 and less than 18 then teenager
 * if both the above statements do not fulfill the age declaration then it goes to the else statement and prints child
 */