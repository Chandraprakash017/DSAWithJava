class Solution {
    class Node {
        int prod;
        int[] count;
        
        Node(int k) {
            count = new int[k];
        }
    }

    int K;
    Node[] tree;

    // Merges two segment tree nodes
    Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;
        
        Node res = new Node(K);
        // The overall product of the merged segment
        res.prod = (left.prod * right.prod) % K;
        
        for (int i = 0; i < K; i++) {
            // Include prefixes from the left child
            res.count[i] += left.count[i];
            
            // Include prefixes that extend into the right child.
            // A prefix in the right child with remainder 'i' gets multiplied 
            // by the total product of the left child.
            int nextMod = (left.prod * i) % K;
            res.count[nextMod] += right.count[i];
        }
        return res;
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            tree[node] = new Node(K);
            int val = nums[l] % K;
            tree[node].prod = val;
            tree[node].count[val] = 1;
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * node + 1, l, mid, nums);
        build(2 * node + 2, mid + 1, r, nums);
        tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            int modVal = val % K;
            tree[node].prod = modVal;
            tree[node].count = new int[K]; // reset counts
            tree[node].count[modVal] = 1;
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            update(2 * node + 1, l, mid, idx, val);
        } else {
            update(2 * node + 2, mid + 1, r, idx, val);
        }
        tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
    }

    Node query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[node];
        }
        int mid = l + (r - l) / 2;
        if (qr <= mid) {
            return query(2 * node + 1, l, mid, ql, qr);
        } else if (ql > mid) {
            return query(2 * node + 2, mid + 1, r, ql, qr);
        } else {
            Node left = query(2 * node + 1, l, mid, ql, qr);
            Node right = query(2 * node + 2, mid + 1, r, ql, qr);
            return merge(left, right);
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        this.K = k;
        tree = new Node[4 * n];
        build(0, 0, n - 1, nums);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // 1. Update the value at the given index
            update(0, 0, n - 1, idx, val);
            
            // 2. Query the range from `start` to `n-1`
            Node res = query(0, 0, n - 1, start, n - 1);
            
            // 3. The answer is the number of valid prefixes that give remainder 'x'
            ans[i] = res.count[x];
        }
        return ans;
    }
}