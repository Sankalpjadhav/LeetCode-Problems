class Solution {
    // Was not able to solve this problem
    private final int mod = (int) 1e9 + 7;
    public int numOfWays(int[] nums) {
        List<Integer> lst = new ArrayList();
        for (int i : nums) {
            lst.add(i);
        }
        
        long res = helper(lst) % mod;
        return (int) res - 1;
    }
    
    private long helper(List<Integer> lst) {
        int size = lst.size();
        if (size <= 2) {
            return 1;
        }
        int root = lst.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i : lst) {
            if (i < root) {
                left.add(i);
            } 
            if (i > root) {
                right.add(i);
            }
        }
        int l = left.size();
        int r = right.size();
        long temp = comb(l + r, l, r) % mod;
        
        long L = helper(left) % mod;
        long R = helper(right) % mod;
        temp = (L * temp) % mod;
        return (R * temp) % mod;
    }
    
    private long comb (int n, int a, int b) {
        long res = 1;
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        for (int i = n; i > a; i--) {
            res *= i;
            res = res % mod;
        }
        for (int i = 1; i <= b; i++) {
            while (res % i != 0) {
                res += mod;
            }
            res /= i;
        }
        return res;
    }
}