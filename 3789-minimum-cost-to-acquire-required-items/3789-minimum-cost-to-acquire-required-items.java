class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;
        long n1 = need1;
        long n2 = need2;

        long both = Math.min(n1, n2);
        long rem1 = n1 - both;
        long rem2 = n2 - both;

        long costOverlap = both * Math.min(cb, c1 + c2);
        long costRem1 = rem1 * Math.min(c1, cb);
        long costRem2 = rem2 * Math.min(c2, cb);

        return costOverlap + costRem1 + costRem2;
    }
}