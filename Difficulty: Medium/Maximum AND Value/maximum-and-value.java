class Solution {
    // Function to check how many elements in the array have all set bits of 'pattern'
    private int checkBit(int pattern, int[] arr) {
        int count = 0;
        for (int num : arr) {
            if ((num & pattern) == pattern) {
                count++;
            }
        }
        return count;
    }

    // Function to find maximum AND value of any pair in array
    public int maxAND(int[] arr) {
        int res = 0;

        // Iterate through all 32 bits from MSB (31st bit) to LSB (0th bit)
        for (int bit = 31; bit >= 0; bit--) {
            // Tentatively set the bit in our candidate result pattern
            int tempPattern = res | (1 << bit);
            
            // If at least 2 numbers match this pattern, fix this bit in res
            if (checkBit(tempPattern, arr) >= 2) {
                res = tempPattern;
            }
        }

        return res;
    }
}