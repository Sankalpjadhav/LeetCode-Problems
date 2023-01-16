class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length-1;
        
        LinkedList<Integer> list = new LinkedList<>();
        int carry = 0;
        while(n >= 0 || k > 0){
            int temp = 0;
            if(k > 0){
                temp = k % 10;
                k/=10;
            }
            int newNum = temp + carry;
            if(n >= 0){
                newNum += num[n];
            }
            
            list.addFirst(newNum%10);
            newNum/=10;
            carry = newNum;
            n--;
        }
        
        if(carry!=0){
            list.addFirst(carry);    
        }
        
        
        return list;
    }
}