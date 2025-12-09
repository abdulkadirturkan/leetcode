class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < n; right++){
            char c = s.charAt(right);

            if(map.containsKey(c)){
                left = Math.max(map.get(c) + 1, left);
            }

            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
