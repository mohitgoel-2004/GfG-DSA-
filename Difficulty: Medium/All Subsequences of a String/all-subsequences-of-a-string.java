class Solution {
    public List<String> powerSet(String s) {
        int n = s.length();
        int totalSubsequences = 1 << n; // Total 2^n combinations
        List<String> result = new ArrayList<>();

        // Generate all subsets using bit manipulation
        for (int i = 0; i < totalSubsequences; i++) {
            StringBuilder sub = new StringBuilder();
            for (int j = 0; j < n; j++) {
                // Check if j-th bit of i is set
                if ((i & (1 << j)) != 0) {
                    sub.append(s.charAt(j));
                }
            }
            result.add(sub.toString());
        }

        // Sort the list to return in lexicographical order
        Collections.sort(result);
        return result;
    }
}