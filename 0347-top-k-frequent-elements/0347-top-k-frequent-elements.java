class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> b.freq - a.freq);
        
        for(int num: nums){
            if(freqMap.containsKey(num)){
                freqMap.put(num, freqMap.get(num)+1);
            }
            else{
                freqMap.put(num, 1);
            }
        }
        
        for(int key: freqMap.keySet()){
            pq.add(new Pair(key, freqMap.get(key)));
        }
        
        int [] result = new int[k];
        int i = 0;
        while(k-- > 0){
            result[i] = pq.poll().element;
            i++;
        }
        
        return result;
    }
}

class Pair{
    Integer element;
    Integer freq;
    
    public Pair(Integer element, Integer freq){
        this.element = element;
        this.freq = freq;
    }
}