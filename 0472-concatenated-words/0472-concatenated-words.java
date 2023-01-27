class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        int n = words.length;
        List<String> result = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            String word = words[i];
            if(consistOfShorterWords(word, set)){
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean consistOfShorterWords(String word, Set<String> set){
        for(int i=0 ;i<word.length(); i++){
            String leftWord = word.substring(0, i);
            String rightWord = word.substring(i);
            if(set.contains(leftWord)){
                if(set.contains(rightWord) || consistOfShorterWords(rightWord, set)){
                    return true;
                }
            }
        }
        return false;
    }
}