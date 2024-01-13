class Solution {
    public int minSteps(String s, String t) {
        int [] charArray = new int[26];
        int n = s.length();
        
        
        for(int i=0;i<n;i++){
            charArray[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<n;i++){
            char ch = t.charAt(i);
            charArray[ch-'a']--;
        }
        
        int numberOfSteps = 0;
        
        for(int i=0;i<26;i++){
            if(charArray[i] > 0){
                numberOfSteps+=charArray[i];
            }
        }
        
        return numberOfSteps;
    }
}

/*
l = 1
e = 3 -> 2
t = 1 -> 0 
c = 1 -> 0 -> -1
0 = 1
d = 1
*/