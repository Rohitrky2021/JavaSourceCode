package T04_Oops;

public class getset {
    public static void main(String[] args) {
        BankEmploye b1 = new BankEmploye();
        b1.setPassword("pass");
        // b1.getPassword();
        System.out.println(b1.getPassword());
    }
}

class BankEmploye {

    private String password;
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}