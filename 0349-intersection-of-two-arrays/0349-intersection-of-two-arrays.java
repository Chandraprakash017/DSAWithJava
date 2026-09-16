class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> intersect=new HashSet<>();

        for(int x:nums1){
            set.add(x);

        }
        for(int x: nums2){
            if(set.contains(x)){
                intersect.add(x);
            }
        }
        int[] ans=new int[intersect.size()];

        int index = 0;
        for (int num : intersect) {
            ans[index++] = num;
        }
        
        return ans;
        
    }
}