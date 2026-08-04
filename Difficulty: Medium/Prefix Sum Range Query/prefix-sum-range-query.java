class Solution {
    public ArrayList<Integer> rangeSumQueries(int[] arr, int[][] queries) {
        // code here
        int n = arr.length;
        int[] prefix = new int[n];
        
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int L = q[0];
            int R = q[1];
            
            if (L == 0) {
                result.add(prefix[R]);
            } else {
                result.add(prefix[R] - prefix[L - 1]);
            }
        }
        
        return result;
    }
}