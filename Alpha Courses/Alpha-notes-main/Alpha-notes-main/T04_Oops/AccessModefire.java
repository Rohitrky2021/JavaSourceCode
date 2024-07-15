package T04_Oops;

public class AccessModefire {
    public static void main(String[] args) {
        student chintu = new student();
        // chintu.age = 20; can't access
        chintu.name = "Mukesh Dixena";
        chintu.semester = 5;

    }
}

class student {
    public String name;
    private int age;
    protected int semester;
    int anything; //defualt
    public int getAge() {
        return age;
    }
    
}