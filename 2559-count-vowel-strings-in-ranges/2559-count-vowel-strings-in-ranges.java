class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        
        int [] prefixArray = new int[n]; // We will keep track of how many vowel strings are there till ith word
        
        if(vowelString(words[0])){
            prefixArray[0] = 1;
        }
        
        for(int i=1;i<n;i++){
            prefixArray[i] = prefixArray[i-1];
            if(vowelString(words[i])){
                prefixArray[i] += 1;
            }
        }
        /*
        System.out.println("PrefixArray: ");
        for(int i=0;i<n;i++){
            System.out.print(prefixArray[i]+",");
        }
        */
        
        int [] result = new int[queries.length];
        
        for(int i=0;i<queries.length;i++){
            int [] query = queries[i];
            result[i] = prefixArray[query[1]];
            if(query[0] - 1 >= 0){
                result[i] -= prefixArray[query[0]-1];
            }
        }
        
        return result;
    }
    
    private boolean vowelString(String str){
        int n = str.length();
        char ch1 = str.charAt(0);
        char ch2 = str.charAt(n-1);
        if((ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') && (ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u')){
            return true;
        }
        
        return false;
    }
}