//WAP to implement method scope
public class methodscope {
    public static void main(String[] args) {
        int s = 45;
        System.out.println("The value of variable s is: "+s);
        //the above print statement we cannot write before we declared s 
        //as it will give an error. 
        //the compiler always checks the code line by line before giving the output
        //hence, if we have declared any variable and want to use it again then
        //we can use it only after we have declared it
    }
}
