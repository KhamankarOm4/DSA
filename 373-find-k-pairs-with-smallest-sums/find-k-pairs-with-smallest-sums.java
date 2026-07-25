class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
       List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Long.compare((long) a[0] + a[1], (long) b[0] + b[1])
        );

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            heap.add(new int[]{nums1[i], nums2[0], 0});
        }

        while (k > 0 && !heap.isEmpty()) {
            int[] current = heap.poll();
            res.add(Arrays.asList(current[0], current[1]));
            k--;

            int nums2Idx = current[2];
            if (nums2Idx + 1 < nums2.length) {
                heap.add(new int[]{current[0], nums2[nums2Idx + 1], nums2Idx + 1});
            }
        }

        return res;
    }
}