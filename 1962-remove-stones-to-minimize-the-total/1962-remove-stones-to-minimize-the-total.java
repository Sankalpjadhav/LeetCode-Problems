class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;
        // Here we need to take out max pile frequently if it is greatest among all other piles

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b - a);
        
        for(int pile: piles){
            maxHeap.offer(pile);
        }

        while(k-- > 0){
            int pile = maxHeap.poll();
            pile -= (int) Math.floor(pile/2);
            maxHeap.offer(pile);
        }

        int stones = 0;
        while(!maxHeap.isEmpty()){
            stones+= maxHeap.poll();
        }

        return stones;  
    }
}