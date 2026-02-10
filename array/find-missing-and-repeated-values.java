class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;

        long expectedSum = (long) N * (N + 1) / 2;
        long expectedSqSum = (long) N * (N + 1) * (2L * N + 1) / 6;

        long actualSum = 0;
        long actualSqSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                actualSum += val;
                actualSqSum += (long) val * val;
            }
        }

        // a - b
        long diff1 = actualSum - expectedSum;

        // a^2 - b^2 = (a - b)(a + b)
        long diff2 = actualSqSum - expectedSqSum;

        // a + b
        long sumAB = diff2 / diff1;

        int a = (int) ((diff1 + sumAB) / 2); // repeating
        int b = (int) (a - diff1);           // missing

        return new int[]{a, b};
    }
}
