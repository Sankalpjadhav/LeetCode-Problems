class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        
        List<List<Character>> list = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(new ArrayList<>());
        }
        boolean flag = true; // Means going down
        int j = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(j == 0){
                list.get(j).add(ch);
                flag = true;
                j++;
            }
            else if(j == numRows-1){
                list.get(j).add(ch);
                flag = false;
                j--;
            }
            else{
                list.get(j).add(ch);
                if(flag == true){
                    j++;
                }
                else{
                    j--;
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<list.size();i++){
            for(Character ch: list.get(i)){
                result.append(ch);
            }
        }
        
        
        return result.toString();
    }
}