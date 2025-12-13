class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] a = new int[words.length];
        for(int i = 0; i < words.length; i++){
            a[i] = frequency(words[i]);
        }

        Arrays.sort(a);
        for(int i = 0; i < queries.length; i++){
            int freq = frequency(queries[i]);
            int idx = upperBound(a, freq);
            ans[i] = (idx==-1)?0:a.length-idx;
        }
        return ans;
    }

    int frequency(String word) {
        char smallest = 'z';
        int c = 0;
        for(char ch:word.toCharArray()) {
            if(ch<smallest) {
                smallest = ch;
            }
        }
        for(char ch:word.toCharArray()) {
            if(ch==smallest) {
                c++;
            }
        }
        return c;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
