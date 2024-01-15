class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        TreeMap<Integer, Integer> losers = new TreeMap<>();
        
        List<List<Integer>> result = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        
        for(int [] match: matches){
            // Put all losers with the count of matches they have lost
            losers.put(match[1], losers.getOrDefault(match[1], 0)+1);
        }
        
        for(Integer player : losers.keySet()){
            if(losers.get(player) == 1){
                // player has lost exactly one match, so include in result[1]
                result.get(1).add(player);
            }
        }
        
        for(int [] match: matches){
            if(losers.get(match[0]) == null){
                result.get(0).add(match[0]);
                losers.put(match[0],-1); // ******
                /*
                    Above line is very important:
                    Consider eg: [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
                    Winners are: [1, 2, 3, 5, 5, 4, 4, 4, 10, 10]
                    Lossers are: [3, 3, 6, 6, 7, 5, 8, 9, 4, 9]
                    
                    We have taken losers map which only consist of losers.
                    We will remove all the lossers from winners list
                    Winners who have never lost: [1, 2, 10, 10], you will get the significance of keeping 10, 10 later.
                    => this means  [1, 2, 10, 10] have never lost, thus won't be present in losers map.
                    Then we will iterate over matches[0] and check if it contains in losers map. If not, then we will
                    include it in result[0]  which contains list of all players that have not lost any matches.
                    
                    If we do not add line (losers.put(match[0],-1);) then we will get result[0] as [1, 2, 10, 10], so                                           after computing 10 for the first time, add <10,-1> in losers map indicating that we have taken care of 10 already.              
                */
            }
        }
        
        Collections.sort(result.get(0));// result.get(1) is already sorted as we have used TreeMap.
        
        return result;
    }
}