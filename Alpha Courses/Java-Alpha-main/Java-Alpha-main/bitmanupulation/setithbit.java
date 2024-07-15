public class setithbit{
    
        public static int setith(int a,int i) {            
            return a | (1<<i);            
        }
        public static void main(String[] args) {
            int a = 10;
            int i  = 2; 
           System.out.println(setith(a,i));
        
    }
}