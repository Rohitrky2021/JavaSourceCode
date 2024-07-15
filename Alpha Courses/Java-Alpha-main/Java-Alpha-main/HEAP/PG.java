import java.util.*;
public class PG{
    static class student implements Comparable<student>{
        String Name;
        int rank;
        public student(String name , int rank){
            this.Name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<student> pg = new PriorityQueue<>();
        pg.add(new student("Aman", 5)); // O(logn)
        pg.add(new student("Rishabh", 2));
        pg.add(new student("Amit", 4));
        pg.add(new student("Aditya", 12));
        
        while(!pg.isEmpty()){
            System.out.println(pg.peek().Name + "--> " + pg.peek().rank); // O(1)
            pg.remove(); // O(logn)
        }
    }
}