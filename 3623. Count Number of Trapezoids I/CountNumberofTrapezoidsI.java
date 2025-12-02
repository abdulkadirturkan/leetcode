class Solution {

    static final long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Long> countByY = new HashMap<>();
        for(int[] p: points){
            countByY.put(p[1], countByY.getOrDefault(p[1], 0L) + 1);
        }
        List<Long> counts = new ArrayList<>(countByY.values());
        int m = counts.size();

        long[] c2= new long[m];
        for(int i = 0; i < m; i++){
            long c = counts.get(i);
            if(c >= 2) c2[i] = (c * (c - 1) / 2) % MOD;
        }

        long ans = 0;

        for(int i = 0; i < m; i++){
            if(c2[i] == 0) continue;
            for(int j = i+1; j < m; j++){
                if(c2[j] == 0) continue;
                ans = (ans + (c2[i] * c2[j]) % MOD) % MOD;
            }
        }

        return (int) ans;
    }
}
