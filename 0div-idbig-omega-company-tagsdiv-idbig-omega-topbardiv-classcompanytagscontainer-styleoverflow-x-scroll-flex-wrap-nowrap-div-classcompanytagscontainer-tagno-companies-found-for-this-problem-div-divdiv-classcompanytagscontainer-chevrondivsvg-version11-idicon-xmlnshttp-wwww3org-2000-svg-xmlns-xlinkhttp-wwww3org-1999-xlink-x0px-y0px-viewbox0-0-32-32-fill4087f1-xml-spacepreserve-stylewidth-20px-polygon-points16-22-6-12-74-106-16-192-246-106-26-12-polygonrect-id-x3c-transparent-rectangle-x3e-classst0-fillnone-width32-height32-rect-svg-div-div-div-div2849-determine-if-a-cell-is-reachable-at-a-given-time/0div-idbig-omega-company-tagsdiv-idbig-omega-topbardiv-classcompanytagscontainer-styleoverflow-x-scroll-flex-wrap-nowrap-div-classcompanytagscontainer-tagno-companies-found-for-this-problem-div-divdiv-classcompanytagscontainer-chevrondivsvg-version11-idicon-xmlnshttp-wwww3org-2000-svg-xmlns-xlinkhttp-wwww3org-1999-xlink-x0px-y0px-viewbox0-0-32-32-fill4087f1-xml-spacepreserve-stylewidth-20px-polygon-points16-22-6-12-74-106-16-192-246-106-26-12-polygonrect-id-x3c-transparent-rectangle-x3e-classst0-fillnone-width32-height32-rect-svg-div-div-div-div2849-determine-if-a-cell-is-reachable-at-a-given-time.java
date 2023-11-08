class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx == fx && sy == fy)return t > 1 || t == 0;
        int distx = Math.abs(sx - fx), disty = Math.abs(sy - fy);
        int togDist = Math.min(distx, disty);
        int leftOverDist = Math.abs(distx - togDist) + Math.abs(disty - togDist);     
        togDist += leftOverDist;
        return togDist <= t;
    }
}