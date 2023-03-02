class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int i = 0;
        
        while(i < chars.length){
            int j = i;
            
            while(j < chars.length && chars[i] == chars[j]){
                j++;
            }
            
            String count = j-i+"";
            chars[index++] = chars[i];
            if(j-i > 1){
                for(char digit : count.toCharArray()){
                    chars[index++] = digit;
                }
            }
            
            i = j;
        }
        
        return index;
    }
}