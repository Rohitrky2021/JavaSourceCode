//WAP to implement copy constructors in java
public class copyconstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "karan";
        s1.roll = 456;
        s1.password = "abcd";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        //we want all the properties of s1 to be copied to s2
        Student s2 = new Student(s1);
        s2.password = "xyz";
        s1.marks[2] = 100;

        //print marks of s2
        for(int i=0; i<3; i++) {
            System.out.println(s2.marks[i]);
        }
    }
}

class Student {
    String name;
    int roll;
    String password;
    int marks[];

    //copy constructor
    Student(Student s1) {
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        this.marks = s1.marks;
    }

    //non-parameterized constructor
    Student() {
        marks = new int[3];
        System.out.println("constructor is called");
    }

    //parameterized constructor
    Student(String name) {
        marks = new int[3];
        this.name = name;
    }

    //parameterized constructor
    Student(int roll) {
        marks = new int[3];
        this.roll = roll;
    }
}