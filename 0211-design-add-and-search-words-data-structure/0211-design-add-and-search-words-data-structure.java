class WordDictionary {
    
    class TrieNode{
        TrieNode [] childrens = new TrieNode[26];
        boolean isWord;
    }

    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.childrens[ch - 'a'] == null){
                node.childrens[ch - 'a'] = new TrieNode();
            }
            node = node.childrens[ch - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char [] chars, int index, TrieNode node){
        if(index == chars.length){
            return node.isWord; // return true;
        }
        
        if(chars[index] == '.'){
            for(int i=0;i<node.childrens.length;i++){
                if(node.childrens[i] !=null && match(chars, index+1, node.childrens[i])){
                    return true;
                }
            }       
        }
        else{
            return node.childrens[chars[index]-'a'] != null && match(chars, index+1, node.childrens[chars[index]-'a']);
        }
    
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */