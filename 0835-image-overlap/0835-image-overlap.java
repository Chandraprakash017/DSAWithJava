import java.util.ArrayList;
import java.util.List;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        
    
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) {
                    list1.add(new int[]{r, c});
                }
                if (img2[r][c] == 1) {
                    list2.add(new int[]{r, c});
                }
            }
        }
        
    
        int[][] shiftCount = new int[2 * n + 1][2 * n + 1];
        int maxOverlap = 0;
        
  
        for (int[] p1 : list1) {
            for (int[] p2 : list2) {
                int dx = p1[0] - p2[0] + n;
                int dy = p1[1] - p2[1] + n;
                
                shiftCount[dx][dy]++;
                maxOverlap = Math.max(maxOverlap, shiftCount[dx][dy]);
            }
        }
        
        return maxOverlap;
    }
}