import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build adjacency list: u -> list of (v, weight)
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        // Min-priority queue storing {cost, node, count}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Distances table: dist[node][count] initialized to infinity
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Base case: start at node 0 with count 1
        pq.offer(new int[]{0, 0, 1});
        dist[0][1] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];
            int count = curr[2];

            if (cost > dist[u][count]) continue;

            // If we reached target node n - 1
            if (u == n - 1) {
                return cost;
            }

            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];

                int nextCount;
                if (labels.charAt(u) == labels.charAt(v)) {
                    nextCount = count + 1;
                } else {
                    nextCount = 1;
                }

                // Check constraints
                if (nextCount <= k) {
                    if (cost + weight < dist[v][nextCount]) {
                        dist[v][nextCount] = cost + weight;
                        pq.offer(new int[]{dist[v][nextCount], v, nextCount});
                    }
                }
            }
        }

        // Find minimum cost among all valid counts at node n - 1
        int ans = Integer.MAX_VALUE;
        for (int c = 1; c <= k; c++) {
            ans = Math.min(ans, dist[n - 1][c]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}