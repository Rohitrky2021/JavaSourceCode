package T03_BitManipulation;

// import javax.sql.rowset.spi.SyncResolver;

public class swapNumber {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a);
        System.out.println(b);
    }
}
