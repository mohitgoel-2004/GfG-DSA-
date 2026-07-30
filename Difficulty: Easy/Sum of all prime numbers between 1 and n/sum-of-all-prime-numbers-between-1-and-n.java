class Solution {
    public int prime_Sum(int n) {
        // code here
          if (n < 2) return 0;

        boolean[] prime = new boolean[n + 1];

        // Mark all numbers as prime initially
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        // Sieve of Eratosthenes
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                sum += i;
            }
        }

        return sum;
    }
}