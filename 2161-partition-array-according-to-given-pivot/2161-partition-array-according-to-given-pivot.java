class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int low = 0, same = 0, high = nums.length;
        
        for(int num: nums){
            if(num < pivot){
                same++;
            }
            else if(num > pivot){
                high--;
            }
        }
        
        int [] res = new int[nums.length];
        
        for(int num: nums){
            if(num < pivot){
                res[low++] = num;
            }
            else if(num == pivot){
                res[same++] = num;
            }
            else{
                res[high++] = num;
            }
        }
        
        return res;
    }
}