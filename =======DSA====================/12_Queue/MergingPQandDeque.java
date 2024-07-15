
    import java.util.ArrayDeque;
    import java.util.PriorityQueue;
    
    public class PriorityQueueWithBothEndsRemoval {
        private PriorityQueue<Integer> priorityQueue;
        private ArrayDeque<Integer> deque;
    
        public PriorityQueueWithBothEndsRemoval() {
            priorityQueue = new PriorityQueue<>();
            deque = new ArrayDeque<>();
        }
    
        public void add(int value) {
            priorityQueue.offer(value);
            deque.offer(value);
        }
    
        public int removeMin() {
            int minValue = priorityQueue.poll();
            deque.remove(minValue);
            return minValue;
        }
    
        public int removeMax() {
            int maxValue = deque.removeLast();
            priorityQueue.remove(maxValue);
            return maxValue;
        }
    
        public static void main(String[] args) {
            PriorityQueueWithBothEndsRemoval queue = new PriorityQueueWithBothEndsRemoval();
            queue.add(5);
            queue.add(3);
            queue.add(7);
            queue.add(2);
    
            System.out.println("Min Value: " + queue.removeMin());
            System.out.println("Max Value: " + queue.removeMax());
        }
    }
    