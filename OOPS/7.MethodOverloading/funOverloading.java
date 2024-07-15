public class funOverloading {
    public static void main (String args[]){
        // System.out.println(calculator.sum(4+5));
        calculator cal=new calculator();
        System.out.println(cal.sum(5, 7));
    }
  
}


class calculator{
    int sum(int a,int b){
        return a+b;
    }
    float sum(float a,float b){
        return a+b;
    }
    int sum(int a,int b,int c){
        return a+b+c;
    }   
 }
