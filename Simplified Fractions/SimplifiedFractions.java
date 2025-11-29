class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();

        for(int denom = 2; denom <=n; denom++){
            for(int numer = 1; numer < denom; numer++){
                if(gcd(numer,denom) == 1){
                    result.add(numer + "/" + denom);
                }
            }
        }

        return result;
    }
    private int gcd(int a, int b){
        while(b != 0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}
