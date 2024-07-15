import java.util.*;
public class validParentisis {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        Stack<Character> ss=new Stack<>();
        for(int i=0;i<=s.length()-1;i++){
            char ch=s.charAt(i);

            if(ch=='{'||ch=='['||ch=='('){
                ss.push(ch);
            }
            else{
                if(ch==')'&& ss.peek()=='('|| ch=='}'&& ss.peek()=='{'|| ch==']'&& ss.peek()=='['){
                    // System.out.println(true);
                    ss.pop();
                }
                if(ss.isEmpty()){
                    System.out.println(false);
                }
                else{
                    System.out.println(false);

                }
            }
            

            

             }
        if(ss.isEmpty()){
            System.out.println(true);
        }
        else{System.out.println(false);}     
        }


    }





    
