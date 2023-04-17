class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        
        List<Boolean> list = new ArrayList<>();
        
        int mostCandies = 0;
        for(int i=0;i<n;i++){
            mostCandies = Math.max(mostCandies, candies[i]);
        }
        
        for(int i=0;i<n;i++){
            if(candies[i] + extraCandies >= mostCandies){
                list.add(true);
            }
            else{
                list.add(false);
            }
        }
        
        return list;
    }
}