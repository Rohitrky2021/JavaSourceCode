
import java.util.*;
import java.util.List;
import java.util.Scanner;

public class BookAllocation{

    public static boolean isPossible(int mid, List<Integer> a, int n, int b) {
        int studentsReq = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            if (a.get(i) > mid) {
                return false;
            }
            
            if (sum + a.get(i) > mid) {
                studentsReq++;
                sum = a.get(i);
                if (studentsReq > b) {
                    return false;
                }
            } else {
                sum += a.get(i);
            }
        }
        return true;
    }

    public static int allocateBooks(List<Integer> a, int n, int b) {
        int start = 0, end = 0, res = -1;
        for (int i = 0; i < n; i++) {
            end += a.get(i);
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(mid, a, n, b)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array and number of students: ");
        int n = sc.nextInt();
        int b = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        System.out.print("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        int ans = allocateBooks(a, n, b);
        System.out.println("Minimum number of pages that can be allocated to a student is: " + ans);
        // sc.close();}
}}