class Solution {
    public int minDeletions(String s) {
        int [] charCountArray = new int[26];
        
        for(int i=0;i<s.length();i++){
            charCountArray[s.charAt(i) - 'a']++;
        }
        
        HashSet<Integer> set = new HashSet<>();
        int numberOfDeletion = 0;
        
        for(int count: charCountArray){
            while(count != 0 && set.contains(count)){
                count--;
                numberOfDeletion++;
            }
            set.add(count);
        }
        
        return numberOfDeletion;
    }
}