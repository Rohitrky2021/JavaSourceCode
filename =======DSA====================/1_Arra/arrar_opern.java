package Arra;
import java.util.*;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSliderUI;
public class arrar_opern {
    // public class Example {


    //     public static int maxma;
    
    //     public static int b;
    
    // }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int marks[]=new int[100];
        int i,n;
        

        System.out.println("enter the no. of values ");
        n=sc.nextInt();

        System.out.println("enter the value 1st");
        for( i=0;i<n;i++){
            marks[i]=sc.nextInt();
            System.out.println("enter the nxt value"+" "+(i+2));
        }

        System.out.println("ur  values are");
        for(i=0;i<n;i++)
        System.out.print(marks[i]+" ");

        
        // System.out.print("\n array length is :"+marks.length);

        // update(marks, 5);

        // for(i=0;i<n;i++)
        // System.out.print(marks[i]+" ");

        // findkey(marks, 25);
        System.out.println("\n"+findkey(marks, 25));

        System.out.println("\n AND the max value is "+maxval(marks));

        // System.out.println("yo :"+ findkey(marks, 5));
        // findkey(marks,5);
        // System.out.println(Example.maxma);

    }
    public static void update(int marks[],int n){
        System.out.println("\n updated......");
        for(int i=0;i<marks.length;i++){
            marks[i]=marks[i]+n;
                }
    
    }
    public static int findkey(int marks[],int key){
        Boolean m=false;
        int i=0,n=0;
        for( i=0;i<marks.length;i++){
            // String mark[]={"ok","by","tata"};
            if (marks[i]==key){
            m=true;
             i=n;}
            // return i;}
        }
        return n;    }

        public static int maxval(int marks[]){
            int i,key,n,min;
            min=Integer.MAX_VALUE;
            key=Integer.MIN_VALUE;
            for(i=0;i<marks.length;i++){
                if(marks[i]>key){
                    key=marks[i];
                      continue;
                }
                if(min>marks[i]){
                    if (marks[i]==0){
                        break;
                    }
                    min=marks[i];
                    
                }
            } //findkey(marks, key);
            System.out.println("and the min value is :" + min);
            return key;

        } 

        
    public static void binary_search(int marks[],int i){
        

        // int l=0,end=Example.maxma;
        


    }       
}
