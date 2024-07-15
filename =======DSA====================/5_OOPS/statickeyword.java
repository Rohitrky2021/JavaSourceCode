//WAP to implement static keyword in java
public class statickeyword {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.schoolname = "JNS";

        Student s2 = new Student();
        System.out.println(s2.schoolname);

        Student s3 = new Student();
        s3.schoolname = "ABC";
    }
}

class Student {
    String name;
    int roll;

    static String schoolname;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}