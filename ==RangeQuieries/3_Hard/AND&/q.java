class q {

    static int f(int[] a, int s, int e) {
        int r = 0, m = 1;
        for (int i = 0; i < 30; i++) {
            boolean c = false;
            int l = 0;
            for (int j = s - 1; j < e; j++) {
                if ((a[j] & (1 << i)) > 0)
                    if (c)
                        l++;
                    else {
                        c = true;
                        l++;
                    }
                else if (c) {
                    r += ((m * l * (l + 1)) / 2);
                    c = false;
                    l = 0;
                }
            }
            if (c) {
                r += ((m * l * (l + 1)) / 2);
                c = false;
                l = 0;
            }
            m *= 2;
        }
        return r;
    }

    static void h(int[] a, int[][] q) {
		System.out.print("Sum of bitwise AND for subarray [");
        for (int[] query : q) {
            int s = query[0];
            int e = query[1];
            int result = f(a, s, e);
            System.out.print( result+" ");
        }
		System.out.println("]");
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 1};
        int n = a.length;
        int[][] q = {{1, 3}, {2, 4}, {1, 4}};
        h(a, q);
    }
}
