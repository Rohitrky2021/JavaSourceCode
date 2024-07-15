//WAP to implement types of constructors- non-parameterized and parameterized
public class typesofconstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1);
        Student s2 = new Student("karan");
        System.out.println(s2.name);
        Student s3 = new Student(123);
        System.out.println(s3.roll);
    }
}
class Student {
    String name;
    int roll;
    //non-parameterized constructor
    Student() {
        System.out.println("constructor is called");
    }

    //parameterized constructor
    Student(String name) {
        this.name = name;
    }

    //parameterized constructor
    Student(int roll) {
        this.roll = roll;
    }
}