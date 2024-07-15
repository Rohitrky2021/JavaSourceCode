public class exam {

    }

    List<Integer> sequence = new ArrayList<>();

    for(
    int i = 1;i<=n-1;i++)
    {
        if (i % n != 1) {
            sequence.add(i);
        }
    }return sequence;

    int[] result = new int[sequence.size()];for(
    int i = 0;i<sequence.size();i++)
    {
        result[i] = sequence.get(i);
    }

    return result;
}

public static void main(String[] args) {
int n = 7;
int[] sequence = findSequence(n);


Math.ma

// 3rd----------------->

public static int getMaximumLengthOfSingleJump(String s) {
    int maxLength = -1; 
    int currentLength = 0; 

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (isSpecialCharacter(c)) {
            currentLength++; 

            if (currentLength > maxLength) {
                maxLength = currentLength; 
            }
        } else {
            currentLength = 0; 
        }
    }

    if (maxLength == 0) {
        return -1;
    }

    return maxLength;
}

private static boolean isSpecialCharacter(char c) {
   
    return !(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z');
}

    // ----------------------------

public static List<Integer> FindTheSequence(int n) {    
         List<Integer> sequence = new ArrayList<>();      
                   for (int i = 1; i < n; i++) {         
                        if ((long) getProduct(i, n) % n == 1) {     
                                        sequence.add(i);          
                                       }         }   
                                              return sequence;  
                                               }

 public static long getProduct(int num, int n) { 
                                                            long product = 1;         
                                                            for (int i = 1; i < n; i++) {             
                                                                if (i != num) {                 
                                                                    product = (product * i) % n;             
                                                                }         }         
                                                                return product;     
                                                            }

    public static List<Integer> FindTheSequence(int n) {
                                                                List<Integer> sequence = new ArrayList<>();
                                                        
                                                                // Finding the lexicographically smallest sequence
                                                                for (int i = 1; i < n; i++) {
                                                                    if ((long) getProduct(i, n) % n == 1) {
                                                                        sequence.add(i);
                                                                    }
                                                                }
                                                        
                                                                return sequence;
                                                            }

    private static long getProduct(int num, int n) {
                                                                long product = 1;
                                                                for (int i = 1; i < n; i++) {
                                                                    if (i != num) {
                                                                        product = (product * i) % n;
                                                                    }
                                                                }
                                                                return product;
                                                            }
