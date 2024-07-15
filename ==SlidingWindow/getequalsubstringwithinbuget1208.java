public class getequalsubstringwithinbuget1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int sa[] = s.toCharArray();
        int st[] = t.toCharArray();

        int tail = 0, ans = 0, sum = 0, targetsum = k, head/* makeing it global */;
        for (head = 0; head < st.length; head++) {
            if (arr[head] == 0)
                k--;
            sum += Math.abs(sa[i]-ta[i]);

            while (sum>maxCost) {
                sum -= Math.abs(sa[i]-ta[i]);
                     
                tail++;
            }

            ans = Math.max(ans, head - tail + 1);
        }

        // return head-tail+1;
        return ans;
    }
}
