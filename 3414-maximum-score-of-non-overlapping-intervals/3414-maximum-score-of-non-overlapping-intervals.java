import java.util.*;

class Solution {
    
    // Helper class to store the DP state: max score and the exact indices chosen
    class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        
        // Convert to a 2D array and append the original index to keep track
        // arr[i] = [start, end, weight, original_index]
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i; 
        }

        // Sort intervals strictly by end time. Tie-breakers by start time and original index
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[3], b[3]);
        });

        // dp[i][k] represents the max score and lexicographically smallest indices 
        // considering the first `i` sorted intervals and picking at most `k` intervals.
        State[][] dp = new State[n + 1][5];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 4; j++) {
                dp[i][j] = new State(0, new int[0]); // Base case: 0 score, empty indices
            }
        }

        for (int i = 1; i <= n; i++) {
            int start = arr[i - 1][0];
            int weight = arr[i - 1][2];
            int origIdx = arr[i - 1][3];

            // Binary search to find the largest index `j` where the interval ends 
            // strictly before the current interval starts (non-overlapping).
            int left = 0, right = i - 1, bestJ = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid][1] < start) {
                    bestJ = mid + 1; // DP table is 1-indexed
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            for (int k = 1; k <= 4; k++) {
                // Option 1: Skip the current interval
                State skip = dp[i - 1][k];

                // Option 2: Take the current interval
                State prev = dp[bestJ][k - 1];
                long newScore = prev.score + weight;
                
                // Add the current interval's original index and maintain sorted order
                int[] newIndices = Arrays.copyOf(prev.indices, prev.indices.length + 1);
                newIndices[newIndices.length - 1] = origIdx;
                Arrays.sort(newIndices);

                State take = new State(newScore, newIndices);

                // Choose the option that maximizes the score or picks the lexicographically smallest array
                if (take.score > skip.score) {
                    dp[i][k] = take;
                } else if (take.score == skip.score) {
                    if (compare(take.indices, skip.indices) < 0) {
                        dp[i][k] = take;
                    } else {
                        dp[i][k] = skip;
                    }
                } else {
                    dp[i][k] = skip;
                }
            }
        }

        // The answer for "at most 4 intervals" from all `n` intervals
        return dp[n][4].indices;
    }

    // Helper method to compare two index arrays lexicographically
    private int compare(int[] a, int[] b) {
        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }
        return Integer.compare(a.length, b.length);
    }
}