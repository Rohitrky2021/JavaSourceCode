package T04_Oops;

public class Constructors {
    public static void main(String[] args) {
        InnerConstructors in = new InnerConstructors();
        InnerConstructors in1 = new InnerConstructors(12);
        InnerConstructors in2 = new InnerConstructors(12, "Mukesh", 'a');
        System.out.println(in.age);
        System.out.println(in1.age);
        System.out.println(in2.age);
    
    }
}

/**
 * InnerConstructors
 */
class InnerConstructors {
    int age;
    String name;
    char ch;
    
    InnerConstructors(){
        System.out.println("Non parameterized");
    }
    InnerConstructors(int age){
        System.out.println("parameterized 1 ");
        this.age = age;
    }
    InnerConstructors(int age, String name, char ch){
        System.out.println("parameterized 2 ");
        this.age = age;
        this.name = name;
        this.ch = ch;
    }
    
}

