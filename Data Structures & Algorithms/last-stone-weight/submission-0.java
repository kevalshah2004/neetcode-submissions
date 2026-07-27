class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i<stones.length; i++){
            pq.add(stones[i]);
        }

        int ans = 0;

        while(!pq.isEmpty()){

            if(pq.size() == 1) return pq.peek();

            int heaviest = pq.remove();
            int heavier = pq.remove();

            ans = heaviest - heavier;

            if(ans!=0)
            pq.add(ans);
        }

        return ans;
    }
}
