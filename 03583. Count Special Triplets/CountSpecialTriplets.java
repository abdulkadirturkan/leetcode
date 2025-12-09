class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long MOD = 1_000_000_007;

        Map<Integer, Long> right = new HashMap<>(), left = new HashMap<>();

        for(int x : nums){
            right.put(x, right.getOrDefault(x, 0L) + 1);
        }

        long ans = 0;

        for(int j = 0; j < n; j++){
            int val = nums[j];

            right.put(val, right.get(val) - 1);
            if(right.get(val) == 0) right.remove(val);

            long need = (long) val * 2;

            long counterLeft = left.getOrDefault((int) need, 0L);
            long counterRight = right.getOrDefault((int) need, 0L);

            ans = (ans + (counterLeft * counterRight) % MOD) % MOD;

            left.put(val, left.getOrDefault(val, 0L) + 1);
        }

        return (int) ans;
    }
}
