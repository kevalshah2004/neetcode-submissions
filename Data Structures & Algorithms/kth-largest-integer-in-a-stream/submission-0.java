class KthLargest {

    PriorityQueue<Integer> pq;
    int kk;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        kk = k;

        for(int i = 0; i<nums.length; i++){
            pq.add(nums[i]);
            if(pq.size()>k) pq.remove();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > kk) pq.remove();
        return pq.peek();
    }
}
