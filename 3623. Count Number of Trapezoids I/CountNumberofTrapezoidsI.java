class Solution {

    static final long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Long> countByY = new HashMap<>();
        for(int[] p: points){
            countByY.put(p[1], countByY.getOrDefault(p[1], 0L) + 1);
        }

        long S = 0;
        long S2 = 0;


       for (long c : countByY.values()) {
            if (c >= 2) {
                long A = (c * (c - 1) / 2) % MOD;
                S = (S + A) % MOD;
                S2 = (S2 + (A * A) % MOD) % MOD;
            }
        }

        long Ssq = (S * S) % MOD;
        long diff = (Ssq - S2 + MOD) % MOD;

        long inv2 = (MOD + 1) / 2;
        long ans = (diff * inv2) % MOD;

        return (int) ans;
    }
}
