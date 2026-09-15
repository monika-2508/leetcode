// Last updated: 9/15/2026, 9:24:37 AM
1import java.util.Collections;
2import java.util.PriorityQueue;
3
4class MedianFinder {
5    // Max-heap stores the smaller half of numbers
6    private PriorityQueue<Integer> maxHeap;
7    // Min-heap stores the larger half of numbers
8    private PriorityQueue<Integer> minHeap;
9
10    public MedianFinder() {
11        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
12        minHeap = new PriorityQueue<>();
13    }
14    
15    public void addNum(int num) {
16        maxHeap.offer(num);
17        // Ensure all elements in maxHeap <= elements in minHeap
18        minHeap.offer(maxHeap.poll());
19        
20        // Balance heap sizes so maxHeap has equal or 1 more element than minHeap
21        if (maxHeap.size() < minHeap.size()) {
22            maxHeap.offer(minHeap.poll());
23        }
24    }
25    
26    public double findMedian() {
27        if (maxHeap.size() > minHeap.size()) {
28            return maxHeap.peek();
29        } else {
30            return (maxHeap.peek() + minHeap.peek()) / 2.0;
31        }
32    }
33}