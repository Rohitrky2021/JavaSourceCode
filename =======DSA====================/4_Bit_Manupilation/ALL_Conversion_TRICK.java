public class ALL_Conversion_TRICK {
    

// Converting Integer to Octal String:

 
int number = 10;
String octalString = Integer.toOctalString(number);
// Converting Integer to Hexadecimal String:
 
int number = 10;
String hexString = Integer.toHexString(number);
// Converting Octal String to Integer:
 
String octalString = "12";
int number = Integer.parseInt(octalString, 8);
// Converting Hexadecimal String to Integer:
 
String hexString = "A";
int number = Integer.parseInt(hexString, 16);
// Converting Binary String to Long:
 
String binaryString = "101010";
long number = Long.parseLong(binaryString, 2);
// Converting Long to Binary String:
 
long number = 42;
String binaryString = Long.toBinaryString(number);
// Converting Long to Hexadecimal String:
 
long number = 42;
String hexString = Long.toHexString(number);
// Converting Long to Octal String:
 
long number = 42;
String octalString = Long.toOctalString(number);

}