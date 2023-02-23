class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Pair> list = new ArrayList<>();
        
        for(int i=0;i<profits.length;i++){
            list.add(new Pair(profits[i], capital[i]));
        }
        
        //System.out.println(list);
        
        Collections.sort(list, new CustomComparator1());
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new CustomComparator2());
        int currentWeight = w;
        int i = 0;
        while(k-- > 0){
            while(i<list.size() && list.get(i).capital <= currentWeight){
                Pair pair = list.get(i);
                pq.add(new Pair(pair.profit, pair.capital));
                i++;
            }
            
            if(pq.isEmpty()){
                break;
            }
            
            Pair p = pq.poll();
            currentWeight += p.profit;
        }
        
        return currentWeight;
    }
}

class Pair{
    int profit;
    int capital;
    
    Pair(int profit, int capital){
        this.profit = profit;
        this.capital = capital;
    }
}

class CustomComparator1 implements Comparator<Pair>{
    @Override
    public int compare(Pair p1, Pair p2){
        if(p1.capital == p2.capital){
            return p2.profit - p1.profit;
        }
        
        return p1.capital - p2.capital;
    }
} 


class CustomComparator2 implements Comparator<Pair>{
    @Override
    public int compare(Pair p1, Pair p2){
        if(p1.profit == p2.profit){
            return p1.capital - p2.capital;
        }
        return p2.profit - p1.profit;
    }
}