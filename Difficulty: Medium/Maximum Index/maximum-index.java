class Solution {
    // Function to find the maximum index difference (j - i) such that arr[i] <= arr[j]
    int maxIndexDiff(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] minLeft = new int[n];
        int[] maxRight = new int[n];

        // minLeft[i] stores the minimum element from index 0 to i
        minLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            minLeft[i] = Math.min(arr[i], minLeft[i - 1]);
        }

        // maxRight[j] stores the maximum element from index j to n-1
        maxRight[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            maxRight[j] = Math.max(arr[j], maxRight[j + 1]);
        }

        // Two-pointer approach to find maximum (j - i)
        int i = 0, j = 0;
        int maxDiff = -1;

        while (i < n && j < n) {
            if (minLeft[i] <= maxRight[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++; // Try to maximize j
            } else {
                i++; // Increase i to look for a smaller element
            }
        }

        return maxDiff;
    }
}