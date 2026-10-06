import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        
      
        for (int num : nums) {
            set.add(num);
        }
        
        List<Integer> ans = new ArrayList<>();
      
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        
        return ans;
    }
}
