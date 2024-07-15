import java.util.*;

public class op1 {
    // main function to be executed here
    public static void main(String args[]) {
        pen p1 = new pen();
        // its constructor;
        p1.setcolor("blue");
        System.out.println(p1.color);
        p1.settip(45);
        System.out.println(p1.tip);

        bankaccount myacc = new bankaccount();
        myacc.setpassword("rohit");
        // System.out.println(myacc.password);*****//can change only but canr see the
        // password

    }
}

class pen {
    String color;
    int tip;// qualities

    void setcolor(String newcolor) {
        color = newcolor;
    }

    // ur functions
    void settip(int newtip) {
        tip = newtip;
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

class bankaccount {
    public String usename;
    private String password;// cant access only change thatis in this only

    public void setpassword(String xyz) {
        password = xyz;
    }

}
