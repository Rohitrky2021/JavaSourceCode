//WAP to convert letters to uppercase
public class letterstouppercase {
    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) == ' ' && i<str.length()-1) { //n-1 because we want to add other words alsp
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i))); //this returns the upper case character
            }
            else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "hi, i am karan";
        System.out.println(toUpperCase(str));
    }
}
