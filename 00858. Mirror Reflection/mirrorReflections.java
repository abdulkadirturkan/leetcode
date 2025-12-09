class Solution {
    public int mirrorReflection(int p, int q) {
        int g = gcd(p,q);
        p/=g;
        q/=g;

        if(p%2 == 1 && q%2 == 1) return 1;
        if(p%2 == 1 && q%2 == 0) return 0;
        return 2;
    }

    private int gcd(int a, int b){
        while(b!=0){
            int t= a%b;
            a= b;
            b= t;
        }
        return a;
    }
}
