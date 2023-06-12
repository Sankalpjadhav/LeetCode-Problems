class Solution {
    public String smallestString(String s) {
        int n = s.length();
        int i = 0;
        char [] array = s.toCharArray();
        // Skip starting 'a'
        while(i < n && array[i] == 'a'){
            i++;
        }
        
        // If after skipping a's if we reach end of the string then we just change the last char to 'z' as we have to perform exactly 1 operation
        if(i >= n){
            array[n-1] = 'z';
            return new String(array);
        }
        
        // If the above condition does not hold it means that we are at the middle of the string
        // Now we will replace each char to its prev char. Note not to replace char 'a'
        
        while(i < n && array[i] != 'a'){
            int ascii = (int)array[i];
            //System.out.println(ascii);
            array[i] = (char) (ascii - 1);
            i++;
        }
        
        return new String(array);
    }
}