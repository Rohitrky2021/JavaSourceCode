import java.util.*;

public class median  {
    public static void main(String[] args) {
        addNum(1);
        addNum(2);
        addNum(3);
        addNum(4);
        // addNum(5);
        System.out.println(findMedian());

    }
    

private static PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
private  static PriorityQueue<Integer> large = new PriorityQueue<>();


private static boolean even = true;


public static double findMedian() {
    if (even)
        return (small.peek() + large.peek()) / 2.0;
    else
        return small.peek();
}

public static void addNum(int num) {
    if (even) {
        large.offer(num);
        small.offer(large.poll());
    } else {
        small.offer(num);
        large.offer(small.poll());
    }
    even = !even;
}
}