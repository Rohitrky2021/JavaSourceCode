class p4 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int c = 0, n = tickets.length, ans = 0,u=0;
        int x=0;

        for (int i : tickets) {
            if (i > tickets[k]) c++;
            if (i >= tickets[k] && x>k) u++;
             
            x++;
        }

        int ls =n-c;

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] <= tickets[k] ) ans += tickets[i];
        }
        System.out.println(ans+" d  "+c+","+u);
        
         

        return (ans+(c-u) * tickets[k])+(tickets[k]-1)*u;
    }

    public static void main(String[] args) {
        p4 solution = new p4();

        // Example 1
        int[] tickets1 = {2, 3, 2};
        int k1 = 2;
        System.out.println("Example 1 Output: " + solution.timeRequiredToBuy(tickets1, k1)); // Output: 6

        // Example 2
        int[] tickets2 = {5, 1, 1, 1};
        int k2 = 0;
        System.out.println("Example 2 Output: " + solution.timeRequiredToBuy(tickets2, k2)); // Output: 8

        int[] t3={84,49,5,24,70,77,87,8};
        int k3 = 3;
        System.out.println("Example 2 Output: " + solution.timeRequiredToBuy(t3, k3)); // Output: 154


    }
}
