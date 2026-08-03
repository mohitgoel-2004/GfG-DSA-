class Solution {
    ArrayList<Integer> smallestDiff(int a[], int b[], int c[]) {
        // Step 1: Sort all three arrays
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;

        int resA = 0, resB = 0, resC = 0;

        // Step 2: Use 3-pointer technique to find the best triplet
        while (i < a.length && j < b.length && k < c.length) {
            int currentMin = Math.min(a[i], Math.min(b[j], c[k]));
            int currentMax = Math.max(a[i], Math.max(b[j], c[k]));
            int currentDiff = currentMax - currentMin;
            int currentSum = a[i] + b[j] + c[k];

            // Update if we find a smaller difference, or a smaller sum in case of tie
            if (currentDiff < minDiff || (currentDiff == minDiff && currentSum < minSum)) {
                minDiff = currentDiff;
                minSum = currentSum;
                resA = a[i];
                resB = b[j];
                resC = c[k];
            }

            // Increment the pointer pointing to the smallest element to reduce difference
            if (currentMin == a[i]) {
                i++;
            } else if (currentMin == b[j]) {
                j++;
            } else {
                k++;
            }
        }

        // Step 3: Put chosen elements into a list and sort in descending order
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(resA, resB, resC));
        result.sort(Collections.reverseOrder());

        return result;
    }
}