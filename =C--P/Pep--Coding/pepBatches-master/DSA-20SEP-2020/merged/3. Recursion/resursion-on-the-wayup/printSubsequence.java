import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str= scn.nextLine();
        
        printSS(str,"");
    }

    public static void printSS(String qsf ,  String asf) {
        if(qsf.length() == 0){
            System.out.println(asf);
            return;
        }
        
        char ch = qsf.charAt(0);
        String roq = qsf.substring(1);
        
        // include
        printSS(roq,asf+ch);
        
        // not include
        printSS(roq,asf);
        
    }

}