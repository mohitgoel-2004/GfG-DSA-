class Solution {
    int countZeroes(int[] arr) {
        // code here
        int count=0;
        for(int n: arr){
            if(n==0){
                count++;
            }
        }
        return count;
    }
}
