class Solution {
    public int numberOfWays(String corridor) {
        final long MOD = 1_000_000_007;

        int totalSeats = 0;
        for(char c : corridor.toCharArray()){
            if(c == 'S') totalSeats++;
        }

        if(totalSeats == 0 || totalSeats % 2 == 1){
            return 0;
        }

        long ways = 1;
        int seatCount = 0;
        int plantCount = 0;
        boolean countingPlants = false;

        for(char c : corridor.toCharArray()){
            if(c == 'S'){
                seatCount++;

                if(countingPlants){
                    ways = (ways * (plantCount + 1)) % MOD;
                    plantCount = 0;
                    countingPlants = false;
                }

                if(seatCount % 2 == 0){
                    countingPlants = true;
                }
            } else if(countingPlants){
                plantCount++;
            }
        }
        return (int) ways;
    }
}
