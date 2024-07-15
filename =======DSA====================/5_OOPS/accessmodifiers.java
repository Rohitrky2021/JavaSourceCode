//WAP to represent access modifiers in java
public class accessmodifiers {
    public static void main(String[] args) {
        BankAccount myAcc = new BankAccount();
        myAcc.username = "karansanghvi";
        myAcc.setPassword("abscedght");
    }
}

//BankAccount is the subclass of the main class which is "accessmodifiers"
class BankAccount {
    /*
     * public is visible to everyone that is
     * (within class, within package, outside package by subclass and outside package)
     */
    public String username; 
    /*
     * private is visible only to the main person who has created it that is
     * (only within class)
     */
    private String password; 
    public void setPassword(String pwd) {
        password = pwd;
    }
}
