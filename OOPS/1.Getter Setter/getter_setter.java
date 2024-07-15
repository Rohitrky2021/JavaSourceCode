import java.util.*;

public class getter_setter {
    // main function to be executed here
    public static void main(String args[]) {
        pen p1 = new pen();
        // its constructor;
        p1.setcolor("blue");
        System.out.println(p1.getcolor());
        p1.settip(45);
        System.out.println(p1.gettip());

        // bankaccount myacc=new bankaccount();
        // myacc.setpassword("rohit");
        // System.out.println(myacc.password);*****//can change only but canr see the
        // password

    }
}

class pen {
    private String color;
    private int tip;// qualities

    String getcolor() {
        return this.color;
    }// THIS IS THE GETTE;USED IN GETTING THE MAIN FUN

    int gettip() {
        return this.tip;
    }

    // THIS IS THE all THE SETETRS;

    void setcolor(String newcolor) {
        this.color = newcolor;
    }

    // ur functions
    void settip(int tip) {
        this.tip = tip;// useful this both the name r same
    }
}

class student {
    String name;
    int age;
    float percent;

    void getpercent(int phy, int chem, int math) {
        percent = (phy + chem + math) / 3;
    }

}
