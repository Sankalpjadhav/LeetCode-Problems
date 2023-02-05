class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n1 = p.length();
        int n2 = s.length();
        List<Integer> result = new ArrayList<>();
        
        int [] array1 = new int[26];
        
        for(int i=0;i<n1;i++){
            array1[p.charAt(i)-'a']++;
        }
        
        for(int i=0;i<=n2-n1;i++){
            int [] array2 = new int[26];
            
            for(int j=0;j<n1;j++){
                array2[s.charAt(i+j)-'a']++;
            }
            
            if(matches(array1, array2)){
                result.add(i);
            }
        }
        
        return result;
    }
    
    private boolean matches(int [] array1, int [] array2){
        for(int i=0;i<26;i++){
            if(array1[i] != array2[i]){
                return false;
            }
        }
        
        return true;
    }
}