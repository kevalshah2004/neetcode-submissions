class Solution {

    public int f(int k, int[] piles){
        int hours = 0;

        for(int i = 0; i<piles.length; i++){
            hours += (piles[i]+k-1)/k;
        }

        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for(int i = 0; i<piles.length; i++){
            if(piles[i] > high) high = piles[i];
        }

        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;
            int hours = f(mid, piles);

            if(hours <= h){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}
