class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        
        for(int stone: stones){
            pq.add(stone);
        }
        
        
        while(pq.size() > 1){
            int firstNum = pq.poll();    
            if(pq.size() == 0){
                return firstNum;
            }
            int secondNum = pq.poll();
            if(firstNum != secondNum){
                pq.add(firstNum - secondNum);
            }
            else{
                if(pq.size() == 0){
                    return 0;
                }
            }
        }
        
        return pq.peek();
    }
}