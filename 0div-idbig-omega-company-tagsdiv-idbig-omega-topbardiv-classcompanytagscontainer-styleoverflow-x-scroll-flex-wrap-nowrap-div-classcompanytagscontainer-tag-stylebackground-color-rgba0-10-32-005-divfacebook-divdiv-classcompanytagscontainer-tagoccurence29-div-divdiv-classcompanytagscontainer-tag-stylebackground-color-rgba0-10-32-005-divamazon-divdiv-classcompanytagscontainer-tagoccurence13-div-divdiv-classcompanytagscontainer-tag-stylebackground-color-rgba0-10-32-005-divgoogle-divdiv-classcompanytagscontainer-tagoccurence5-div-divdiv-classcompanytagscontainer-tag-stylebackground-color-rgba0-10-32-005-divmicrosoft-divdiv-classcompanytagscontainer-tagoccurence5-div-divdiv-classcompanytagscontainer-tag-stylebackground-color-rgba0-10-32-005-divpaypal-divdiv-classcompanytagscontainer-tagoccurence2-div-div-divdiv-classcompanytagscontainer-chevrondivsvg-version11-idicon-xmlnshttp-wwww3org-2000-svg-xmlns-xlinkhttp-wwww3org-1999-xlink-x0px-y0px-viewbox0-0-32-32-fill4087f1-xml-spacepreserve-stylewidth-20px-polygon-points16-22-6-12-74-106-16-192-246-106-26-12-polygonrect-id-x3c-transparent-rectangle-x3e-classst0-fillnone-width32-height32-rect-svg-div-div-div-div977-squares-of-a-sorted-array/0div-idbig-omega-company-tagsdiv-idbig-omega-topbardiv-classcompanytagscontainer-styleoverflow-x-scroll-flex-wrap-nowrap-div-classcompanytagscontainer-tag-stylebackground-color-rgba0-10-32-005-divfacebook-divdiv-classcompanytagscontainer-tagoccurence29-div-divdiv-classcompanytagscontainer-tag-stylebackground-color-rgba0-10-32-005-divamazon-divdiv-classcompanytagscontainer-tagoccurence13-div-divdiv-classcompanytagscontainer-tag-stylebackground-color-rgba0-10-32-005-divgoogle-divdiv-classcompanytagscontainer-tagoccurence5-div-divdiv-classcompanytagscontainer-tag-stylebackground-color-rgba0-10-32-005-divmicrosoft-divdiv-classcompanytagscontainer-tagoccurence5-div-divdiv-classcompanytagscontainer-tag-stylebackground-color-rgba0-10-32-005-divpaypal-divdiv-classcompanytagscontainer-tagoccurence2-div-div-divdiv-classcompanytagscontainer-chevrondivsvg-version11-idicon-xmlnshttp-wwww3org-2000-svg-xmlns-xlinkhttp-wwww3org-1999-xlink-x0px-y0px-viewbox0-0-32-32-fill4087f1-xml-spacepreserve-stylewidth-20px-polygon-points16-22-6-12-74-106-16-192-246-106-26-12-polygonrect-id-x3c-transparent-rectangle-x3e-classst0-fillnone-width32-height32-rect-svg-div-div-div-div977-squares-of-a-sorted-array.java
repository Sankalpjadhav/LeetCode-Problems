class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int [] result = new int[n];
        int i = 0;
        int j = n-1;
        
        for(int t=n-1;t>=0;t--){
            if(Math.abs(A[i]) > Math.abs(A[j])){
                result[t] = A[i] * A[i];
                i++;
            }
            else{
                result[t] = A[j] * A[j];
                j--;;
            }
        }
        return result;
    }
}

/*

Trivial solution

public int[] sortedSquares(int[] A) {
        int [] result=new int[A.length];
        int k=0;
        for(int num:A){
            result[k++]=num*num;
        }
        Arrays.sort(result);
        return result;
    }

*/