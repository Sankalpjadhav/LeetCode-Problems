class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        
        for(int gift: gifts){
            pq.add(gift);
        }
        
        long result = 0;
        while(k-- > 0){
            int gift = pq.poll();
            pq.add((int)Math.sqrt(gift));
        }
        
        while(pq.size() > 0){
            result += pq.poll();
        }
        
        return result;
    }
}