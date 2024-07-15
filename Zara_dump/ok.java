public class ok {
    public long minimumSteps(String s) {
        char a[] = s.toCharArray();
        long c = change(a);
        System.out.println(c);
        return c;
    }

    public static long change(char a[]) {
        int s = 0, end = a.length - 1;
        int i = 0;
        long count = 0;

        while (i < end) {
            if (a[i] == '0') {
                // swap(a, s, i);
                s++;
                // System.err.println(a[i]);
                i++;
            } else if (a[end] == '1') {
                end--;
            } else {
                swap(a, end, i);
                count++;
                // System.err.println(a[end]);
                end--;
            }
        }

        for (int j = 0; j < a.length; j++) {
            System.err.println(a[j]);
        }

        return count;
    }

    public static void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
