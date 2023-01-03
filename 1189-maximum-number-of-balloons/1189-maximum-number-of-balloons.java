class Solution {
    public int maxNumberOfBalloons(String text) {
        if(text.length() < "balloon".length()){
            return 0;
        }
        
        int maxNumberOfInstances = (int) 1e5;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(isBalloon(ch)){
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
        }
        
        if(map.size() != 5){ // b a l o n -> unique chars in balloon
            return 0;
        }
        
        for(Character ch : map.keySet()){
            if(ch == 'l' || ch == 'o'){
                // these chars are occuring twice, so we will divide by 2
                if(map.get(ch)/2 < maxNumberOfInstances){
                    maxNumberOfInstances = map.get(ch)/2;
                }
            }
            else{
                if(map.get(ch) < maxNumberOfInstances){
                    maxNumberOfInstances = map.get(ch);
                }
            }
        }
        
        return maxNumberOfInstances;
    }
    
    private boolean isBalloon(char ch){
        if(ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n'){
            return true;
        }
        
        return false;
    }
}