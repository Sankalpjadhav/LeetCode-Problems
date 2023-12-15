class Solution {
    public String destCity(List<List<String>> paths) {
        String destinationCity = "";
        
        HashMap<String, String> adjMap = new HashMap<>();
        
        for(List<String> path: paths){
            adjMap.put(path.get(0), path.get(1));
        }
        
        String city = paths.get(0).get(0);
        
        while(adjMap.get(city) != null){
            city = adjMap.get(city);
        }
        
        return city;
    }
}