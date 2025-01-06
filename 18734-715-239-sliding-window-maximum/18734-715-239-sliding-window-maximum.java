class Solution {

    // Optimal approach: TC: O(n) + O(n) + O(n) + O(K)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] result = new int[n-k+1];

        int [] nextGreaterElementIndexes = new int[n];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextGreaterElementIndexes[i] = n;
            }
            else{
                nextGreaterElementIndexes[i] = stack.peek();
            }
            stack.push(i);
        }

        for(int i=0;i<=n-k;i++){
            int nextGreaterElementInd = i;
            while(nextGreaterElementIndexes[nextGreaterElementInd] < i+k){
                nextGreaterElementInd = nextGreaterElementIndexes[nextGreaterElementInd];
            }
            result[i] = nums[nextGreaterElementInd];
        }
        
        return result;
    }
}

/*
Brute Force: TLE bcoz time complexity: O(N*k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] result = new int[n-k+1];

        for(int i=0;i<=n-k;i++){
            result[i] = nums[i];
            for(int j=i;j<i+k;j++){
                result[i] = Math.max(result[i], nums[j]);
            }
        }

        return result;
    }
*/