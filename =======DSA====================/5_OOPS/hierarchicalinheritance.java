//WAP to implement hierarchical inheritance
public class hierarchicalinheritance {
    public static void main(String[] args) {
        
    }
}

//base class or parent class
class Animal {
    //properties in animal classs
    String color;
    //functions inherited in the base class- animal class
    void eat () {
        System.out.println("the animal eats");
    }

    void breathe () {
        System.out.println("the animal breathes");
    }
}

class Mamal extends Animal {
    void walk() {
        System.out.println("walks");
    }
}

class Fish extends Animal {
    void swim() {
        System.out.println("swims");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("fly");
    }
}