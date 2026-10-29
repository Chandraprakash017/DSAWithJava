import java.util.*;

class Solution {
    class SegmentTree {
        int n;
        int[] tree;

        public SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        public void build(int node, int start, int end, int[] arr) {
            if (start == end) {
                tree[node] = arr[start];
                return;
            }
            int mid = (start + end) / 2;
            build(2 * node, start, mid, arr);
            build(2 * node + 1, mid + 1, end, arr);
            tree[node] = tree[2 * node] ^ tree[2 * node + 1];
        }

        public void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = (start + end) / 2;
            if (start <= idx && idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }
            tree[node] = tree[2 * node] ^ tree[2 * node + 1];
        }

        public int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return 0;
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end) / 2;
            return query(2 * node, start, mid, l, r) ^ query(2 * node + 1, mid + 1, end, l, r);
        }
    }

    private List<List<Integer>> adj;
    private int[] parent, depth, heavy, head, pos;
    private int curPos;

    private int dfs(int u, int p, int d, int[] sz) {
        parent[u] = p;
        depth[u] = d;
        sz[u] = 1;
        int maxSub = 0;
        heavy[u] = -1;
        for (int v : adj.get(u)) {
            if (v != p) {
                int sub = dfs(v, u, d + 1, sz);
                sz[u] += sub;
                if (sub > maxSub) {
                    maxSub = sub;
                    heavy[u] = v;
                }
            }
        }
        return sz[u];
    }

    private void decompose(int u, int h, String s, int[] flatArr) {
        head[u] = h;
        pos[u] = curPos;
        flatArr[curPos++] = 1 << (s.charAt(u) - 'a');

        if (heavy[u] != -1) {
            decompose(heavy[u], h, s, flatArr);
        }

        for (int v : adj.get(u)) {
            if (v != parent[u] && v != heavy[u]) {
                decompose(v, v, s, flatArr);
            }
        }
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        int[] sz = new int[n];

        dfs(0, -1, 0, sz);

        curPos = 0;
        int[] flatArr = new int[n];
        decompose(0, 0, s, flatArr);

        SegmentTree st = new SegmentTree(n);
        st.build(1, 0, n - 1, flatArr);

        List<Boolean> result = new ArrayList<>();
        char[] charArr = s.toCharArray();

        for (String qStr : queries) {
            String[] parts = qStr.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                charArr[u] = c;
                st.update(1, 0, n - 1, pos[u], 1 << (c - 'a'));
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int xorMask = 0;

                while (head[u] != head[v]) {
                    if (depth[head[u]] > depth[head[v]]) {
                        int temp = u; u = v; v = temp;
                    }
                    xorMask ^= st.query(1, 0, n - 1, pos[head[v]], pos[v]);
                    v = parent[head[v]];
                }
                if (depth[u] > depth[v]) {
                    int temp = u; u = v; v = temp;
                }
                xorMask ^= st.query(1, 0, n - 1, pos[u], pos[v]);

                // A path can form a palindrome if at most one bit is set
                if ((xorMask & (xorMask - 1)) == 0) {
                    result.add(true);
                } else {
                    result.add(false);
                }
            }
        }

        return result;
    }
}