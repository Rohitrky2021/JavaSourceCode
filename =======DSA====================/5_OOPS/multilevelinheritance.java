//WAP to implement multi level inheritance
public class multilevelinheritance {
    public static void main(String[] args) {
        Dog dobby = new Dog();
        dobby.eat();
        dobby.legs = 4;
        System.out.println(dobby.legs);
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
    int legs;
}

class Dog extends Mamal {
    String breed;
}