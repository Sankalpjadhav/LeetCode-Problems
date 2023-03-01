class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n-1, new int[n]);
        return nums;
    }
    
    private void mergeSort(int [] nums, int left, int right, int [] temp){
        if(left < right){
            int mid = left + (right - left)/2;
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid+1, right, temp);
            
            merge(nums, left, mid+1, right, temp);
        }
    }
    
    private void merge(int [] nums, int left, int mid, int right, int [] temp){
        int i = left;
        int j = mid;
        int k = left;
        
        while(i <= mid-1 && j <= right){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i];
                i++;
            }
            else{
                temp[k++] = nums[j];
                j++;
            }
        }
        
        while(i<=mid-1){
            temp[k++] = nums[i];
            i++;
        }
        
        while(j<=right){
            temp[k++] = nums[j];
            j++;
        }
        
        for(int m=left;m<=right;m++){
            nums[m] = temp[m];
        }
    }
}