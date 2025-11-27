class Solution {
    public int majorityElement(int[] nums) {
        int c = nums[0], count = 1;

        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                c = nums[i];
                count = 1;
            } else if(nums[i] == c){
                count++;
            } else{
                count--;
            }
        }
        return c;
    }
}
