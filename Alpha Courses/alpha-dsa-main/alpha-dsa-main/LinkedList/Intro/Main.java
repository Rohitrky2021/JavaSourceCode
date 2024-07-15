package LinkedList.Intro;

public class Main {
    public static void main(String[] args) {

        // LL list = new LL();
        // list.insertFirst(5);
        // list.insertFirst(4);
        // list.insertFirst(3);
        // list.insertFirst(2);
        // list.insertFirst(1);
        // list.insertLast(9);
        // list.insertAt(20, 4);
        // list.display();
        // System.out.println(list.deleteFirst());
        // list.display();
        // System.out.println(list.deleteAt(4));
        // list.display();

        DLL list = new DLL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.display();
        list.insertLast(0);
        list.display();
    }
}
