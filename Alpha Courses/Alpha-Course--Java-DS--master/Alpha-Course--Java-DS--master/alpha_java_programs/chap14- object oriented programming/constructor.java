//WAP to implement constructors in java
public class constructor {
    public static void main(String[] args) {
        /*
         * using new keyword we are creating a new "student" object with the 
         * help of the constructor created in student class
         */
        Student s1 = new Student("karan"); 
        System.out.println(s1.name);
    }
}

class Student {
    String name;
    int roll;
    //constructor created here with the name student 
    Student(String name) {
        this.name = name;
    }
}