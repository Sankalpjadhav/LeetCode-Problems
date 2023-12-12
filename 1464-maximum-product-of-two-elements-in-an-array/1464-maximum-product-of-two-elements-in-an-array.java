class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        
        for(int num: nums){
            maxHeap.add(num);
        }
        
        int firstNum = maxHeap.poll() - 1;
        int secondNum = maxHeap.poll() - 1;
        
        return firstNum * secondNum;
    }
}