class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}



------------------
  O(1) solution

  class Solution {
    public boolean isPowerOfThree(int n) {
        int maxPowerOf3 = 1162261467;//3^19
        return n > 0 && maxPowerOf3 % n == 0; 
    }
}
