package T02_String;
public class WhatAreString {

    public static void main(String[] args) {
        char arr[] = {'a', 'b', 'c'};
        
        // string is class 
        
        // creation mathod 1
        String str1 = "abcd";

        // creation mathod 2
        String str2 = new String("xyz");

        // String are immutable
        System.out.println(arr);
        System.out.println( str1 + str2);
    }
    
}