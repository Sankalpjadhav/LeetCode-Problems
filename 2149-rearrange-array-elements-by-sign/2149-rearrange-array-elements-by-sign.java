class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int positive=0, negative=1;

        for(int i=0; i<n; i++){
            if(nums[i]>0){
                res[positive]=nums[i];
                positive += 2;
            }
            else{
                res[negative]=nums[i];
                negative += 2;
            }
        }

        return res;
    }
}

/*
NOT SO EFFICIENT
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        
        List<Integer> positiveIntegers = new ArrayList<>();
        List<Integer> negativeIntegers = new ArrayList<>();
        
        for(int num: nums){
            if(num < 0){
                negativeIntegers.add(num);
            }
            else{
                positiveIntegers.add(num);
            }
        }
        int j = 0;
        int k = 0;
        for(int i=0; i<n; i++){
            if(i % 2 == 0){
                // Handling positive Integers
                nums[i] = positiveIntegers.get(j);
                j++;
            }
            else{
                // Handling negative Integers
                nums[i] = negativeIntegers.get(k);
                k++;
            }
        }
        
        return nums;
    }
*/

