class Solution {
    public long distinctNames(String[] ideas) {
        int n = ideas.length;
        Set<String> set = new HashSet<>();
        
        for(String idea: ideas){
            set.add(idea);
        }
        
        //System.out.println(set);
        
        long result = 0;
        int [][] freq = new int[26][26];
        for(int i=0;i<n;i++){
            int firstChar = ideas[i].charAt(0)-'a';
            for(char ch='a';ch<='z';ch++){
                String str = ch + ideas[i].substring(1);
                if(!set.contains(str)){
                    freq[firstChar][ch-'a']++;
                }
            }
        }
        
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                result += (long)freq[i][j] * (long)freq[j][i];
            }
        }
        
        return result;
    }
}