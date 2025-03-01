class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> result = new ArrayList<>();
        int [] chars = new int[26];
        // Keep track of last index of a particular char
        for(int i=0;i<n;i++){
            chars[s.charAt(i) - 'a'] = i;
        }


        for(int i=0;i<n;i++){
            int startIndex = i;
            char ch = s.charAt(i);
            int endIndex = chars[ch - 'a'];

            for(int k = startIndex+1;k<=endIndex;k++){
                char subch = s.charAt(k);
                endIndex = Math.max(endIndex, chars[subch - 'a']);
            }

            result.add(endIndex - startIndex + 1);
            i = endIndex;
        }

        return result;
    }

}

/*
Good Exaplaination: https://youtu.be/aUVEMnlcw4E?si=CY14j_yriEEA5RNK

Brute force:

public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            int startIndex = i;
            char ch = s.charAt(i);
            int endIndex = endIndexOfCh(ch, s, startIndex+1);

            for(int k = startIndex+1;k<=endIndex;k++){
                char subch = s.charAt(k);
                endIndex = Math.max(endIndex, endIndexOfCh(subch, s, k+1));
            }

            result.add(endIndex - startIndex + 1);
            i = endIndex;
        }

        return result;
    }

    private int endIndexOfCh(char ch, String s, int startIndex){
        int endIndex = startIndex-1;
        int n = s.length();
        for(int j=startIndex;j<n;j++){
            if(ch == s.charAt(j)){
                endIndex = j;
            }
        }

        return endIndex;
    }
*/