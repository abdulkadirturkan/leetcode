class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int i=0;i < n; i++){
            if(i>0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1;j < n; j++){
                if(j > 1 && nums[j] == nums[j - 1]) continue;

                long remaining = (long)target - nums[i] - nums[j];
                int left = j + 1, right = n - 1;

                while(left < right){
                    long sum = nums[left] + nums[right];

                    if(sum == remaining){
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        left++;
                        right--;

                        while(left < right && nums[left] == nums[left - 1]) left++;
                        
                        while(left < right && nums[right] == nums[right + 1]) right++;
                    } else if(sum < remaining){
                        left++;
                    } else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
