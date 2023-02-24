class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        // Which number will be largest : Obviously ODD as we are doubling it
        
        // Initially add all the elements and only perform operation on odd element
        
        for(int num: nums){
            if(num % 2 == 0){
                // Even: Add that element as it is without performing operation
                set.add(num);
            }
            else{
                // Odd
                set.add(num * 2);
            }
        }
        // Now we have converted all the elements into an even number (As odd * 2 = even)
        int ans= Integer.MAX_VALUE;
        
        while(true){
            int maxNum = set.last();
            int minNum = set.first();
            ans = Math.min(ans, maxNum - minNum);
            if(maxNum % 2 == 0){
                // Remove the current max element and divide by 2 and add it back to set as tje max element was even
                set.remove(maxNum);
                set.add(maxNum/2);
            }
            else{
                break;
            }
        }
        
        return ans;
    }
}