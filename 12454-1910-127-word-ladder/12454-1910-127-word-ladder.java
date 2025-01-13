class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();

        for(String word: wordList){
            set.add(word);
        }

        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int result = 0;
        while(!queue.isEmpty()){
            result++;
            int size = queue.size();
            while(size-- > 0){
                String currentWord = queue.poll();
                if(currentWord.equals(endWord)) return result;

                for(int i=0;i<currentWord.length();i++){
                    for(char ch='a';ch<='z';ch++){
                        if(ch == currentWord.charAt(i)) continue;
                        String neighbor = currentWord.substring(0, i) + ch + currentWord.substring(i+1);
                        if(set.contains(neighbor)){
                            queue.add(neighbor);
                            set.remove(neighbor);
                        }
                    }
                }
            }
        }

        return 0;
    }
}