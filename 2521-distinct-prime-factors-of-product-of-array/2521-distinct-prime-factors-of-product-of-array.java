class Solution {
    public int distinctPrimeFactors(int[] a) {
        HashSet<Integer> m = new HashSet<Integer>();
        int n  = a.length;

        for (int i = 0; i < n; i++) {
            int sq = (int)Math.sqrt(a[i]);
 
            for (int j = 2; j <= sq; j++) {
                if (a[i] % j == 0) {
 
                    m.add(j);
 
                    while (a[i] % j == 0) {
                        a[i] = a[i] / j;
                    }
                }
            }
 

            if (a[i] > 1) {
                m.add(a[i]);
            }
        }
 

        return m.size();
    }
    
    
}