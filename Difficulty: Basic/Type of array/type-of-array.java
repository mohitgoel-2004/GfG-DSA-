class Solution {
    int typeOfArr(int[] arr) {
        int n = arr.length;
        
        // Find the maximum and minimum elements in the array
        int maxEle = arr[0];
        int minEle = arr[0];
        
        for (int i = 1; i < n; i++) {
            if (arr[i] > maxEle) maxEle = arr[i];
            if (arr[i] < minEle) minEle = arr[i];
        }

        // Case 1: Ascending order (First is min, Last is max)
        if (arr[0] == minEle && arr[n - 1] == maxEle) {
            return 1;
        }
        
        // Case 2: Descending order (First is max, Last is min)
        if (arr[0] == maxEle && arr[n - 1] == minEle) {
            return 2;
        }
        
        // Case 3: Descending Rotated
        if (arr[0] < arr[n - 1]) {
            return 3;
        }
        
        // Case 4: Ascending Rotated
        return 4;
    }
}