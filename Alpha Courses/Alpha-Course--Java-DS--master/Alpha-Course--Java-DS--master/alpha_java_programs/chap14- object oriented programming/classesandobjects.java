//WAP to represent classes and objects 
public class classesandobjects {
    public static void main(String[] args) {
        /*
         * by this new keyword we are making a new space in memory where all the 
         * properties of pen will be stored anc created a pen object called p1
         */
        Pen p1 = new Pen();
        p1.setColor("blue"); //to set the color in p1
        System.out.println(p1.color);
        p1.setTip(5); //to set the tip in p1
        System.out.println(p1.tip);
        
    }
}

//pen is a subclass of the main class
class Pen {
    //saving different properties of class "pen"
    String color;
    int tip;
    
    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}