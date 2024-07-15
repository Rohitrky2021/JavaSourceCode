public class OOPs{
    public static void main(String[] args) {
       Horse h1 = new Horse();
       System.out.println(h1.colour);
    }
}
class Animal{
    String colour ; 
    Animal(){
        System.out.println("at animal constructor");
    }
}
class Horse extends Animal{
    Horse(){
        super();
        super.colour="brown";
        System.out.println("at animal constructor");
    }
}

 

