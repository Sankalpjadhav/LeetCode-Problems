class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> countOfOnes = new ArrayList<>();
        
        for(String floor: bank){
            int count = 0;
            for(int i=0;i<floor.length();i++){
                if(floor.charAt(i) == '1'){
                    count++;
                }
            }
            
            if(count != 0){
                countOfOnes.add(count);
            }
        }
        
        int numberOfLaserBeams = 0;
        if(countOfOnes.size() <= 1){
            return 0;
        }
        
        int i = 0;
        while(i < countOfOnes.size() - 1){
            numberOfLaserBeams += (countOfOnes.get(i) * countOfOnes.get(i+1));
            i++;
        }
        
        return numberOfLaserBeams;
    }
}