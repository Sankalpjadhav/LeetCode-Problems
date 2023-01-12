class Solution {
    public int numFriendRequests(int[] ages) {
        int friendRequestCount = 0;
        
        HashMap<Integer, Integer> ageCount = new HashMap<>();
        
        for(int age : ages){
            ageCount.put(age, ageCount.getOrDefault(age, 0)+1);
        }
        
        for(int age1 : ageCount.keySet()){
            for(int age2 : ageCount.keySet()){
                if(!canTheyConnect(age1, age2)){
                    continue;
                }
                
                int count1 = ageCount.get(age1);
                int count2 = ageCount.get(age2);
                
                if(age1 == age2){
                    friendRequestCount += (count1 - 1) * count2; // every other person will connect. if x connects to y, y will not connect to x, so we did -1
                }
                else{
                    friendRequestCount += (count1 * count2);
                }
            }
        }
        
        return friendRequestCount;
    }
    
    private boolean canTheyConnect(int person1, int person2){
        if(person2 <= (0.5 * person1 + 7)){
            return false;
        }
        
        if(person2 > person1){
            return false;
        }
        
        if(person2 > 100 && person1 < 100){
            return false;
        }
        
        return true;
    }
}