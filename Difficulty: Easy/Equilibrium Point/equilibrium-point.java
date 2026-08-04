class Solution {
    public static int findEquilibrium(int arr[]) {
        // code here
        long totalSum = 0;
        
        for (int num : arr) {
            totalSum += num;
        }
        
        long leftSum = 0;
        
        for (int i = 0; i < arr.length; i++) {
          long rightSum = totalSum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i; 
            }
            
            leftSum += arr[i];
        }
        
        return -1;
    }
}
