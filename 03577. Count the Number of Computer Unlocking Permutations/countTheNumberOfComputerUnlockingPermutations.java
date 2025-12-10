class Solution {
    static final long MOD = 1_000_000_007L;
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        for(int i = 1; i < n; i++){
            if(complexity[i] <= complexity[0]){
                return 0;
            }
        }

        int ans = 1;
        for(int i = 2; i < n; i++){
            ans = (int) (((long) ans * i) % MOD);
        }

        return ans;
    }
}
