// Last updated: 7/16/2026, 4:12:13 PM
// =====================
// Approach 1: Priority Queue
// =====================

class Solution {
    HashMap<Integer,Integer> freq;

    public int[] topKFrequent(int[] nums, int k) {

        freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(var e : freq.entrySet()){
            pq.offer(new int[]{e.getKey(), e.getValue()});
        }

        int[] res = new int[k];
        int idx = 0;

        while(k-- > 0){
            res[idx++] = pq.poll()[0];
        }

        return res;
    }
}