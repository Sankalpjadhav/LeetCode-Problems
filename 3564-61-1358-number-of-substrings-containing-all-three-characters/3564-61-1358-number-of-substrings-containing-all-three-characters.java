class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int start  = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(end < n){
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0)+1);

            while(map.size() == 3){
                count+=(n - end);
                char charAtStart = s.charAt(start);
                map.put(charAtStart, map.get(charAtStart)-1);
                if(map.get(charAtStart) == 0){
                    map.remove(charAtStart);
                }
                start++;
            }
            
            end++;
        }

        return count;
    }

}

/*
Brute force solution: Generating all sustrings of length 3 and checking if it satisfies the condition

public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i=0;i<=n-3;i++){
            for(int j=i;j<n;j++){
                if(j - i + 1 < 3){
                    continue;
                }
                if(check(s, i, j)){
                    count++;
                }
            }
        }

        return count;
    }

    private boolean check(String s, int start, int end){
        Set<Character> set = new HashSet<>();

        for(int i=start;i<=end;i++){
            set.add(s.charAt(i));
            if(set.size() == 3){
                return true;
            }
        }

        return set.size() == 3;
    }
*/