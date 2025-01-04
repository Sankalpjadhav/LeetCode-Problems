class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int circularArrayLength = 2*n - 1;
        Stack<Integer> container = new Stack<Integer>();
        int [] result = new int[n];

        for(int i=circularArrayLength;i>=0;i--){
            while(!container.isEmpty() && nums[i % n] >= container.peek()){ // >= bcoz we have duplicate elements in the nums
                container.pop();
            }
            if(i < n){
                if(container.isEmpty()){
                    result[i] = -1;
                }
                else{
                    result[i] = container.peek();
                }
            }

            container.push(nums[i%n]);
        }

        return result;
    }
}