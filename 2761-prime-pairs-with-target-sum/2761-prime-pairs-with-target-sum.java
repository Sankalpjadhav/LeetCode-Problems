class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean [] primeNumbers = sieveOfEratosthenes(n);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=2;i<=n/2;i++){
            int x = i;
            int y = n - x;
            if(primeNumbers[x] && primeNumbers[y]){
                result.add(new ArrayList<>(Arrays.asList(x,y)));        
            }
        }
        
        return result;
    }
    
    private boolean [] sieveOfEratosthenes(int n){
        boolean [] primeNumbers = new boolean[n+1];
        Arrays.fill(primeNumbers, true);
        primeNumbers[0] = false;
        primeNumbers[1] = false;
        
        for(int i=2;i<=n/2;i++){
            if(primeNumbers[i] && (long)i*i <= n){
                for(int j=i*i;j<=n;j+=i){
                    primeNumbers[j] = false;
                }
            }
        }
        
        return primeNumbers;
    }
}

/*
The Sieve of Eratosthenes is an algorithm used to find all prime numbers up to a given limit. It works by iteratively marking as composite (i.e., not prime) the multiples of each prime, starting with 2. The algorithm starts by creating a list of all integers from 2 to the limit. It then marks the first number, 2, as prime and removes all multiples of 2 from the list. The next unmarked number in the list is 3, which is also prime, so it marks it and removes all multiples of 3 from the list. This process continues until all numbers in the list have been marked as prime or composite. The remaining unmarked numbers are the prime numbers up to the given limit.
*/