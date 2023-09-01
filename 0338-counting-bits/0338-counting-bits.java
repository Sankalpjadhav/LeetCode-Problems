class Solution {
    public int[] countBits(int num) {
        int [] result =  new int[num+1];
        for(int i=1;i<=num;i++){
            int count=0;
            int temp = i;
            while(temp>0){
                int rightMostSetBit = temp & -temp;
                temp -= rightMostSetBit;
                count++;
            }
            result[i] = count;
        }
        return result;
    }
}