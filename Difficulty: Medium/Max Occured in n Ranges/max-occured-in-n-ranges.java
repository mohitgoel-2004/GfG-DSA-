class Solution {
    public int maxOccured(List<Integer> L, List<Integer> R) {
        // code here
        int maxR = 0;
        int n = L.size();

        for (int i = 0; i < n; i++) {
            maxR = Math.max(maxR, R.get(i));
        }


        int[] freq = new int[maxR + 2];

        for (int i = 0; i < n; i++) {
            freq[L.get(i)] += 1;
            freq[R.get(i) + 1] -= 1;
        }

        int maxCount = freq[0];
        int resultNum = 0;

        for (int i = 1; i <= maxR; i++) {
            freq[i] += freq[i - 1]; 
            if (freq[i] > maxCount) {
                maxCount = freq[i];
                resultNum = i;
            }
        }

        return resultNum;
    }
}
