import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        
        // Min-heap storing pairs of [freeTime, serverId]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        int[] count = new int[k];
        int maxRequests = 0;
        
        for (int i = 0; i < arrival.length; i++) {
            int startTime = arrival[i];
            int endTime = startTime + load[i];
            
            // Free up servers that have completed their tasks
            while (!pq.isEmpty() && pq.peek()[0] <= startTime) {
                available.add(pq.poll()[1]);
            }
            
            // If all servers are busy, drop the request
            if (available.isEmpty()) {
                continue;
            }
            
            // Find the preferred server starting from (i % k)
            Integer serverId = available.ceiling(i % k);
            if (serverId == null) {
                serverId = available.first(); // Wrap around to 0
            }
            
            // Assign request to the selected server
            available.remove(serverId);
            pq.offer(new int[] { endTime, serverId });
            count[serverId]++;
            maxRequests = Math.max(maxRequests, count[serverId]);
        }
        
        // Collect all servers that handled the maximum number of requests
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }
        
        return result;
    }
}