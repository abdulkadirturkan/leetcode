int gcd(int x, int y){
    while(y != 0){
        int t = x % y;
        x = y;
        y = t;
    }
    return x;
}

int commonFactors(int a, int b) {
    int g=gcd(a,b);
    int output = 0;
        
    for(int i = 1; i*i <=g; i++){
        if(g%i == 0){
            output++;
            if(i != g/i) output++;
        }
    }
    return output;
}
