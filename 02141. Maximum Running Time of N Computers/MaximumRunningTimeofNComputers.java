class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for(int b: batteries) sum += b;

        long left = 0, right = sum / n;

        while(left < right){
            long mid = right - (right - left) / 2;
            if(canRun(mid, n, batteries)){
                left = mid;
            } else{
                left = left;
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canRun(long T, int n, int[] batteries){
        long total = 0;
        for(int b : batteries) {
            total += Math.min(b, T);
            if(total >= (long)n * T) return true;
        }
        return total >= (long)n * T;
    }
}
