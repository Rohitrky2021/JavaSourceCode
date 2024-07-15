import java.util.*;
public class permuMain {
    


    // M1--> Using Passing by Value -->i.e every time new String is Generated 
    public ArrayList<String> stringPermutations(String s) {
        ArrayList<String> result = new ArrayList<String>();
        stringPermutations( "", s, result); 
        return result;
    }
    
    private void stringPermutations(String prefix, String suffix, List<String> results) {
        if (suffix.length() == 0) {
            results.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
            stringPermutations(prefix + suffix.charAt(i),
                              suffix.substring(0, i) + suffix.substring(i+1, suffix.length()));
            }
        }
    }
    
   // M2--> Using Passing by Reference -->i.e every time Same String is Used    
    public List<int[]> listPermutations(int[] a) {
        ArrayList<int[]> results= new ArrayList<int[]>();
        listPermutations(a, 0, results);
        return l;
    }
    
    private void listPermutations(int[] a, int start, List<int[]> result) {  // This is wew learn in Adityaverma Video
        if (start >= a.length) {
            result.add(a.clone());  // Thats why adding only the ans values bcoz string is same so it will cahnge !
        } else {
            for (int i = start; i < a.length; i++) {
                swap(a, start, i); // jo kaam menee string k saath kiya 
                listPermutations(a, start+1, result);
                swap(a, start, i); // Backtracking Step to return whi jo mujhe functrion ne diya tha
            }
        } 
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    } 
}
