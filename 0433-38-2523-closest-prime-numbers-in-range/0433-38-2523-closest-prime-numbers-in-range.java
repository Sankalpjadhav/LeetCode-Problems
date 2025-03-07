class Solution {

    private boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }

    public int[] closestPrimes(int L, int R) {
 
        List<Integer> l = new ArrayList<>();
        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;
        
        for (int i = L; i <= R; i++) {


            if (i == 1 || i == 0)
                continue;


            int flag = 1;

            if(!isPrime(i)){
                flag = 0;
            }
            // for (int j = 2; j <= i / 2; ++j) {
            //     if (i % j == 0) {
            //         flag = 0;
            //         break;
            //     }
            // }


            if (flag == 1){
                if(l.size() != 0){
                    int num1 = l.get(l.size()-1);
                    int num2 = i;
                    int diff = Math.abs(num1 - num2);
                    if( diff < min){
                        min = diff;
                        p1 = num1;
                        p2 = num2;
                    }
                }
                l.add(i);
            }
            
        }
        
        //System.out.println(l);
        
        if(l.size() < 2){
            return new int[]{-1,-1};
        }
        
        
        return new int[]{p1, p2};
        
    }
}