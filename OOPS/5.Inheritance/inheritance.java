public class inheritance {
    public static void main(String args[]) {
        fish shark = new fish();
        // System.out.println(shark.eat);
        shark.eat();
        shark.swim();

    }
}

class animal {
    String color;

    // String breath;
    void eat() {
        System.out.println("it eats");
    }

    void breath() {
        System.out.println("it breaths");
    }
}

// inheritent kur de property
// ur child or derived class;
class fish extends animal {
    // System.out.println("its fish");
    int fins;

    void swim() {
        System.out.println("ya they swim on water");
    }

}