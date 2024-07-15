class Solution1 {
    public int minOperations(String s) {
        char a[] = s.toCharArray();
        int zer=0,one=0,zer1=0,one1=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]!='0'  && i % 2 == 0) {
            zer++;
            } else if(a[i]=='0'  && i % 2 != 0) {
               zer++;
            }
        }
 
        for (int i = 0; i < a.length; i++) {
            if (a[i]!='1'  && i % 2 == 0) {
            zer1++;
            } else if(a[i]=='1'  && i % 2 != 0){
              zer1++;
            }
        }
       
        return Math.min(zer, zer1);
    }
}

class Solution {
    public int minOperations(String s) {
        char[] a = s.toCharArray();
        int operations = 0;

        for (int i = 0; i < a.length; i++) {
            if ((a[i] - '0') != (i % 2)) {
                operations++;
            }
        }

        return Math.min(operations, a.length - operations);
    }
}
