class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i) == 'R'){
                queue1.add(i);
            }
            else{
                queue2.add(i);
            }
        }
        
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            int rIndex = queue1.poll();
            int dIndex = queue2.poll();
            
            if(rIndex < dIndex){
                queue1.add(rIndex + n);
            }
            else{
                queue2.add(dIndex + n);
            }
        }
        
        return queue1.size() > queue2.size() ? "Radiant" : "Dire";
    }
}