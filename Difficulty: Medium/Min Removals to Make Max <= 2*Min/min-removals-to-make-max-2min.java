class Solution {
    public int minRemoval(int[] arr) {
        // code here
        int n= arr.length;
        if(n<=1) return 0;
        
        Arrays.sort(arr);
        
        int maxLen =1;
        int j=0;
        
        for(int i=0;i<n;i++){
            while(j<n && (long) arr[j]<= 2L*arr[i]){
                j++;
            }
            maxLen = Math.max(maxLen, j-i);
        }
        return n-maxLen;
    }
}