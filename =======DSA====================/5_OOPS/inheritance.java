//WAP to implement inheritance
public class inheritance {
    public static void main(String[] args) {
        Fish shark = new Fish();
        //when we write .eat it means that the fish class inherits the eat
        //property from the animal class which is the base class
        shark.eat();
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

//derived class or child class
//when we use the keyword extends it means that this class is inheriting properties
//from another class
class Fish extends Animal {
    //properties in fish class
    int fins;
    void swim () {
        System.out.println("the fish swims in water");
    }
}