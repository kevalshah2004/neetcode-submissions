class Solution {
    public int findMin(int[] arr) {
        int high = arr.length-1;
        int low = 0;
        int n = arr.length;

        while(low <= high){
            int mid = (low+high)/2;
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            if(mid-1>=0) left = arr[mid-1];
            if(mid+1<n) right = arr[mid+1];
            if(arr[mid] < left && arr[mid] < right) return arr[mid];
            if(arr[mid] < arr[high]){
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return -1;
    }
}
