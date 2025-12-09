class Solution {
    public int numTrees(int n) {
        int[] bs = new int[n+1];
        bs[0] = 1;

        for(int i = 1; i <= n; i++){
            bs[i] = 0;
            for(int j = 1; j <= i; j++){
                bs[i] += bs[j - 1] * bs[i - j];
            }
        }

        return bs[n];
    }
}
