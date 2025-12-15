class Solution {
    public long getDescentPeriods(int[] prices) {
        long result = 0;
        long curr = 0;
        for(int i = 0; i < prices.length; i++){
            if(i > 0 && prices[i - 1] - prices[i] == 1){
                curr++;
            } else{
                curr = 1;
            }
            result += curr;
        }

        return result;
    }
}
