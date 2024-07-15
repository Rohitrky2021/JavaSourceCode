public class PQToArrayConvert {
    int[] topKElements = new int[k];

    // Can use this Commented Lines Also just for One LinerWE Use
    // int index = 0;
    // while (!priorityQueue.isEmpty()) {
    //     topKElements[index++] = priorityQueue.poll();
    // }

    // return topKElements;
    return topKElements = priorityQueue.stream().mapToInt(Integer::intValue).toArray();
}
