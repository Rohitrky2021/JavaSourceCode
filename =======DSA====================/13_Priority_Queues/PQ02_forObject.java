 

import java.util.*;

public class PQ02_forObject {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        Student(int rank, String name) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>();
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student(12, "A"));
        pq.add(new Student(1, "B"));
        pq.add(new Student(32, "C"));
        pq.add(new Student(132, "D"));
        pq.add(new Student(14, "E"));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }
    }
}
