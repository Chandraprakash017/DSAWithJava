import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0;
        long ops = 0;
        // Stores [prefixMaxVal, count] for elements in current window [l..r]
        Deque<long[]> deque = new ArrayDeque<>();

        int r = n - 1;
        for (int l = n - 1; l >= 0; l--) {
            long x = nums[l];
            long cnt = 1;

            while (!deque.isEmpty() && deque.peekFirst()[0] < x) {
                long[] front = deque.pollFirst();
                ops += (x - front[0]) * front[1];
                cnt += front[1];
            }
            deque.addFirst(new long[]{x, cnt});

            while (l <= r && ops > k) {
                long[] back = deque.peekLast();
                ops -= (back[0] - nums[r]);
                back[1]--;
                if (back[1] == 0) {
                    deque.pollLast();
                }
                r--;
            }

            ans += (r - l + 1);
        }

        return ans;
    }
}