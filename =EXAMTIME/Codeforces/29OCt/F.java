import java.util.*;
import java.io.*;

public class F {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int q = input.nextInt();
            Tree tree = new Tree();
            tree.init();
            
            while (q-- > 0) {
                int type = input.nextInt();
                if (type == 1) {
                    int v = input.nextInt();
                    tree.addChild(v);
                } else {
                    int v = input.nextInt();
                    long x = input.nextLong();
                    tree.addValue(v, x);
                }
            }
            
            tree.printValues();
        }
    }
}

class Tree {
    ArrayList<ArrayList<Integer>> children;
    ArrayList<Long> values;
    int size;
    
    void init() {
        children = new ArrayList<>();
        values = new ArrayList<>();
        children.add(new ArrayList<>());
        values.add(0L);
        size = 1;
    }
    
    void addChild(int v) {
        children.add(new ArrayList<>());
        children.get(v).add(size);
        values.add(0L);
        size++;
    }
    
    void addValue(int v, long x) {
        values.set(v, values.get(v) + x);
        for (int child : children.get(v)) {
            addValue(child, x);
        }
    }
    
    void printValues() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            long value = values.get(i);
            result.append(value).append(" ");
        }
        System.out.println(result);
    }
}
