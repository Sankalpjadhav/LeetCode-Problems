class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length;
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] - (mid + 1) >= k){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left + k;
    }
}

/*
Time complexity: n + k
Space complexity: n

public int findKthPositive(int[] arr, int k) {
        int n = k + arr.length;
        Set<Integer> set = new HashSet<>();
        
        for(int num: arr){
            set.add(num);
        }
        
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                k--;
            }
            if(k == 0){
                return i;
            }
        }
        
        return 0;
    }
*/