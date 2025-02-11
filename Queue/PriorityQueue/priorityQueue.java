// Priority Queue is based on Heap data structure

import java.util.Collections;
import java.util.PriorityQueue;

public class priorityQueue {
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();  //Default implementation is min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  //For implementation of max heap

        pq.add(5);
        pq.add(10);
        pq.add(3);
        pq.add(8);

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
