class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // code here
        // Create a Min-Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Process each element in the array
        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest element
            }
        }

        // Store result in ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        // Sort in decreasing order as required
        Collections.reverse(result);

        return result;
    }
}
