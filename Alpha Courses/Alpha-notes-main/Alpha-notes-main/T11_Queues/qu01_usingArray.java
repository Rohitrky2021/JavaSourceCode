package T11_Queues;

public class qu01_usingArray {

    public static void main(String[] args) {
        Queue qu = new Queue(5);
        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        while(!qu.isEmpty()){
            System.out.println(qu.remove());
        }
    }
}

class Queue {
    static int arr[];
    static int size;
    static int rear;

    Queue(int n) {
        arr = new int[n];
        size = n;
        rear = -1;
    }

    boolean isEmpty() {
        return rear == -1;
    }

    void add(int data) {
        if (rear == size - 1) {
            System.out.println("queue is full");
            return;
        }
        rear++;
        arr[rear] = data;
    }

    int remove() {
        if (isEmpty()) {
            System.out.println("que is empty");
            return -1;
        }
        int val = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return val;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("que is empty");
            return -1;
        }
        return arr[0];
    }
}
