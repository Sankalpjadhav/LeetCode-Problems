class SmallestInfiniteSet {
    HashSet<Integer> set;
    PriorityQueue<Integer> minHeap;

    public SmallestInfiniteSet() {
        set = new HashSet<>();
        minHeap = new PriorityQueue<>();
        
        for(int i=1;i<=1000;i++){
            minHeap.add(i);
            set.add(i);
        }
    }
    
    public int popSmallest() {
        int smallest = minHeap.poll();
        set.remove(smallest);
        return smallest;
    }
    
    public void addBack(int num) {
        if(!set.contains(num)){
            set.add(num);
            minHeap.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */