import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        // 1. Build original tree
        List<List<Integer>> origTree = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            origTree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            origTree.get(parent[i]).add(i);
        }

        // 2. Find new parents via DFS + backtracking on character ancestors
        int[] newParent = Arrays.copyOf(parent, n);
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        assignNewParents(0, origTree, s, lastSeen, newParent);

        // 3. Build final tree and compute subtree sizes
        List<List<Integer>> finalTree = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            finalTree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            finalTree.get(newParent[i]).add(i);
        }

        int[] ans = new int[n];
        computeSubtreeSize(0, finalTree, ans);
        return ans;
    }

    private void assignNewParents(
            int u,
            List<List<Integer>> tree,
            String s,
            int[] lastSeen,
            int[] newParent) {
        int idx = s.charAt(u) - 'a';
        if (u != 0 && lastSeen[idx] != -1) {
            newParent[u] = lastSeen[idx];
        }

        int prevAncestor = lastSeen[idx];
        lastSeen[idx] = u;

        for (int v : tree.get(u)) {
            assignNewParents(v, tree, s, lastSeen, newParent);
        }

        // Backtrack so sibling branches don't see this node as an ancestor
        lastSeen[idx] = prevAncestor;
    }

    private int computeSubtreeSize(int u, List<List<Integer>> tree, int[] ans) {
        int size = 1;
        for (int v : tree.get(u)) {
            size += computeSubtreeSize(v, tree, ans);
        }
        ans[u] = size;
        return size;
    }
}