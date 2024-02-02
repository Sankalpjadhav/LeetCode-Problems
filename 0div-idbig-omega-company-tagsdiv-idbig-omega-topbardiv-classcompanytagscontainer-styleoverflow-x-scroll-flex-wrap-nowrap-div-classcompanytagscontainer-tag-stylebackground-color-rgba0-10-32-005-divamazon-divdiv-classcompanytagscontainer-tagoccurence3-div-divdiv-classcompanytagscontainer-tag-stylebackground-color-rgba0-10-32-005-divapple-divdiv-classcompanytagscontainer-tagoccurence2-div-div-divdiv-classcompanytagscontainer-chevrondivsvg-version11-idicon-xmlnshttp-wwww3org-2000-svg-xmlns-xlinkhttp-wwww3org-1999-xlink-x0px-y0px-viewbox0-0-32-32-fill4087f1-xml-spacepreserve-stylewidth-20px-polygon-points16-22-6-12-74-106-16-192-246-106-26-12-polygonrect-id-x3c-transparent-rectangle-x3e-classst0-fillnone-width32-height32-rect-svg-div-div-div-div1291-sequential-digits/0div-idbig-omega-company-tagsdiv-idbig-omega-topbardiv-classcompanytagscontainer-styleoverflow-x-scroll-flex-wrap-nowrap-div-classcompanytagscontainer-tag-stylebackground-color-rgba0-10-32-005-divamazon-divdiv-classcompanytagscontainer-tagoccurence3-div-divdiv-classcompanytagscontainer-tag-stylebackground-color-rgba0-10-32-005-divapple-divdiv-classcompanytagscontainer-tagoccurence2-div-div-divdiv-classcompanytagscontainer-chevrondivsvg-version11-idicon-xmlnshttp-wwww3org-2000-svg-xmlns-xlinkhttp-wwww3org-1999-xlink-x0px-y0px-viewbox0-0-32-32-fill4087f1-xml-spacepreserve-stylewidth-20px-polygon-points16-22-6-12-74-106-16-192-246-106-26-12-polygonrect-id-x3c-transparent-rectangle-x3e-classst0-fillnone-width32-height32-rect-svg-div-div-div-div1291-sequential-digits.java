class Solution {
    public void SeqDigit(String str, int low, int high, List<Integer> list){
        int val = Integer.valueOf(str);
        if(val>=low && val <=high) {
            list.add(val);
        }
        if(val > high) return ;
        char lastch = str.charAt(str.length()-1);
        
        if(lastch == '9') return;
        String nextdigit = Integer.toString(Character.getNumericValue(lastch) + 1);
        SeqDigit(str+nextdigit, low, high, list);
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list  = new ArrayList<>();
        for(int i=1; i<=9; i++){
            SeqDigit(Integer.toString(i) , low, high, list);
        }
        Collections.sort(list);
        return list;
    }
}