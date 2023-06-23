class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();
        int n = groupSizes.length;
        
        for(int i=0;i<n;i++){
            if(map.containsKey(groupSizes[i])){
                List<List<Integer>> list = map.get(groupSizes[i]);
                if(list.get(list.size()-1).size() == groupSizes[i]){
                    list.add(new ArrayList<>());
                    list.get(list.size()-1).add(i);
                    map.put(groupSizes[i], list);
                }
                else{
                    list.get(list.size()-1).add(i);
                }
            }
            else{
                map.put(groupSizes[i], new ArrayList<>());
                map.get(groupSizes[i]).add(new ArrayList<>());
                map.get(groupSizes[i]).get(0).add(i);
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(List<List<Integer>> largeGroup: map.values()){
            for(List<Integer> group : largeGroup){
                result.add(group);
            }
        }
        
        return result;
    }
}