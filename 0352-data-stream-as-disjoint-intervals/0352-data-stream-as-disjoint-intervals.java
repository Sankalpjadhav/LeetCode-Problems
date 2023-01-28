class SummaryRanges {
    TreeMap<Integer, int[]> treeMap;

    public SummaryRanges() {
        treeMap = new TreeMap<>();
    }
    
    public void addNum(int value) {
        if(treeMap.containsKey(value)) {
            return;
        }
        Integer lowerKey = treeMap.lowerKey(value);
        Integer higherKey = treeMap.higherKey(value);
        
        if(lowerKey != null && higherKey != null &&
            value == treeMap.get(lowerKey)[1] + 1 && 
            value == treeMap.get(higherKey)[0] - 1) {
              /*
              The new num can connect two exisitng intervals, like this case [a, b-1], b, [b+1, c]
              Action: Update the smaller interval to be [a, c]. And remove the larger interval [b+1, c]
              */
            treeMap.get(lowerKey)[1] = treeMap.get(higherKey)[1];
            treeMap.remove(higherKey);
        } 
        else if (lowerKey != null && value <= treeMap.get(lowerKey)[1] + 1) {
            /*
            The new num b can expand the largest smaller interval, like this case [a, b-1], b;
            OR, new num b can be put into the smaller interval, like [a, b], b
            Action: Update the smaller interval to be [a, MAX(upperBound_of_smaller_interval, new_num)]
            */
            treeMap.get(lowerKey)[1] = Math.max(value, treeMap.get(lowerKey)[1]);
        } 
        else if (higherKey != null && value == treeMap.get(higherKey)[0] - 1) { // Case 4
            /*
            The new b can expand the smallest larger interval, like b, [b+1, c]
            Action: Update the smallest larger interval to be [b, c]
            */
            treeMap.put(value, new int[]{value, treeMap.get(higherKey)[1]});
            treeMap.remove(higherKey);
        } 
        else {
            // The new num is not close to any exising key. Thus, just add a new interval like [val, val];
            treeMap.put(value, new int[]{value, value});
        }
    }
    
    public int[][] getIntervals() {
        List<int[]> list = new ArrayList<>(treeMap.values());
        return list.toArray(new int[list.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
