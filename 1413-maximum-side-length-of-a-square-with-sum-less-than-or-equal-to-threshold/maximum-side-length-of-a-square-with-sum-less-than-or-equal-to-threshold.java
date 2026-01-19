class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int r = mat.length, c = mat[0].length;
        int[][] pre = new int[r + 1][c + 1];

        // Build prefix sum
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                          + pre[i - 1][j]
                          + pre[i][j - 1]
                          - pre[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(r, c);

        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (existsSquare(pre, mid, threshold)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean existsSquare(int[][] pre, int size, int threshold) {
        for (int i = size; i < pre.length; i++) {
            for (int j = size; j < pre[0].length; j++) {
                int sum = pre[i][j]
                        - pre[i - size][j]
                        - pre[i][j - size]
                        + pre[i - size][j - size];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}