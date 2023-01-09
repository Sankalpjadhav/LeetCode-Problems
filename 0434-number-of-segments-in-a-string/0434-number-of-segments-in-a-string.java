class Solution {
    public int countSegments(String s) {
        if(s.length() == 0){
            return 0;
        }
        
        String[] words = s.split(" ");
        int count = 0;
        for(int i=0;i<words.length;i++){
            if(words[i].trim().length() != 0){
                count++;
            }
        }
        return count;
    }
}