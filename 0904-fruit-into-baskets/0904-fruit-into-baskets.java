class Solution {
    public int totalFruit(int[] fruits) {
        // keep fruit and its frequency here.
        Map<Integer,Integer> frqmap = new HashMap<>();
        int lft = 0, rgt = 0, n = fruits.length;
        int maxlen = 1;
        for(rgt = 0; rgt < n; rgt++){
            int type = fruits[rgt];
            frqmap.put(type, 1 + frqmap.getOrDefault(type, 0));
            if (frqmap.size() > 2){
                int rollOff = fruits[lft];
                frqmap.put(rollOff, frqmap.get(rollOff) - 1);
                if (frqmap.get(rollOff) == 0){
                    frqmap.remove(rollOff);
                }
                lft++;
            }
            maxlen = Math.max(maxlen, rgt - lft + 1);        
        }
        return maxlen;
    }
}