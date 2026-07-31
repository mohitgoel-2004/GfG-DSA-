class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // Max-heap to store the smaller half of numbers
        PriorityQueue<Integer> leftMax = new PriorityQueue<>(Collections.reverseOrder());
        
        // Min-heap to store the larger half of numbers
        PriorityQueue<Integer> rightMin = new PriorityQueue<>();
        
        ArrayList<Double> result = new ArrayList<>();
        
        for (int num : arr) {
            // Step 1: Insert into the appropriate heap
            if (leftMax.isEmpty() || num <= leftMax.peek()) {
                leftMax.add(num);
            } else {
                rightMin.add(num);
            }
            
            // Step 2: Rebalance heaps so leftMax has at most 1 more element than rightMin
            if (leftMax.size() > rightMin.size() + 1) {
                rightMin.add(leftMax.poll());
            } else if (rightMin.size() > leftMax.size()) {
                leftMax.add(rightMin.poll());
            }
            
            // Step 3: Compute current median
            if (leftMax.size() > rightMin.size()) {
                result.add((double) leftMax.peek());
            } else {
                result.add((leftMax.peek() + rightMin.peek()) / 2.0);
            }
        }
        
        return result;
    }
}