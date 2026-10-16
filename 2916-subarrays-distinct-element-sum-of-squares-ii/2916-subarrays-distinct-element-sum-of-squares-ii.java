class Solution {
    static final int MOD = 1000000007;
    long[] tree;
    long[] lazy;
    long[] sumSquares;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        tree = new long[4 * n];
        lazy = new long[4 * n];
        sumSquares = new long[4 * n];

        java.util.HashMap<Integer, Integer> lastSeen = new java.util.HashMap<>();
        long totalSum = 0;
        long currentSum = 0;

        for (int j = 0; j < n; j++) {
            int val = nums[j];
            int l = lastSeen.getOrDefault(val, -1) + 1;
            lastSeen.put(val, j);

            // 1. Update range [l, j] by adding 1 to distinct counts
            // (c + 1)^2 = c^2 + 2c + 1, so we add (2 * rangeSum + length) to sum of squares
            update(1, 0, n - 1, l, j);

            // 2. Query the sum of squares of all subarrays ending at index j
            currentSum = query(1, 0, n - 1, 0, j);
            totalSum = (totalSum + currentSum) % MOD;
        }

        return (int) totalSum;
    }

    private void push(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = (l + r) / 2;
            apply(2 * node, l, mid, lazy[node]);
            apply(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void apply(int node, int l, int r, long val) {
        long len = (r - l + 1);
        // sumSquares_new = sumSquares_old + 2 * sum_old * val + len * val^2
        sumSquares[node] = (sumSquares[node] + 2 * val * tree[node] + len * val % MOD * val) % MOD;
        tree[node] = (tree[node] + len * val) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void update(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, 1);
            return;
        }
        push(node, l, r);
        int mid = (l + r) / 2;
        if (ql <= mid) update(2 * node, l, mid, ql, qr);
        if (qr > mid) update(2 * node + 1, mid + 1, r, ql, qr);
        tree[node] = (tree[2 * node] + tree[2 * node + 1]) % MOD;
        sumSquares[node] = (sumSquares[2 * node] + sumSquares[2 * node + 1]) % MOD;
    }

    private long query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return sumSquares[node];
        }
        push(node, l, r);
        int mid = (l + r) / 2;
        long res = 0;
        if (ql <= mid) res = (res + query(2 * node, l, mid, ql, qr)) % MOD;
        if (qr > mid) res = (res + query(2 * node + 1, mid + 1, r, ql, qr)) % MOD;
        return res;
    }
}