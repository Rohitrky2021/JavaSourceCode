//WAP to implement get and set keywords in java
public class getandset {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setColor("blue");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());
    }
}
class Pen {
    private String color;
    private int tip;
    String getColor() { //get used to return the value
        return this.color; //this is used to refer the object which is "color" in this case
    }
    int getTip() {
        return this.tip;
    }
    void setColor(String newColor) {
        this.color = newColor;
    }
    void setTip(int newTip) {
        this.tip = newTip;
    }
}