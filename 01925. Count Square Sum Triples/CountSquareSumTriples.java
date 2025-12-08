class Solution {
    public int countTriples(int n) {
        int output = 0;
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                int sum = a * a + b * b;
                for(int c = 1; c <= n; c++){
                    if(c*c == sum){
                        output++;
                    }
                }
            }
        }
        return output;
    }
}
