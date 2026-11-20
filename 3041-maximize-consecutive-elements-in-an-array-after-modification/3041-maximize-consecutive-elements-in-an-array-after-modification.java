import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int x : nums) {
            int nextLen = dp.getOrDefault(x, 0) + 1;
            dp.put(x + 1, nextLen);
            ans = Math.max(ans, nextLen);

            int currLen = dp.getOrDefault(x - 1, 0) + 1;
            dp.put(x, currLen);
            ans = Math.max(ans, currLen);
        }

        return ans;
    }
}