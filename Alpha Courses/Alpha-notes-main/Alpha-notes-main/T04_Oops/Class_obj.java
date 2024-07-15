package T04_Oops;

public class Class_obj {
    public static void main(String[] args) {
        beer chintu = new beer();
        chintu.age = 20;
        chintu.name = "Mukesh Dixena";
        chintu.semester = 5;

    }
}
class beer{
    String name;
    int age;
    int semester;
}