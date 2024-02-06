class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<String>> mpp = new HashMap<String,ArrayList<String>>();

        for(String str:strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = String.valueOf(ch);
            if(!mpp.containsKey(s)) mpp.put(s,new ArrayList<String>());
            mpp.get(s).add(str);
        }
        return new ArrayList<>(mpp.values());
    }
}