class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        Map<Character, int[]> map = new HashMap<>();

        for(char c: votes[0].toCharArray()){
            map.put(c, new int[n]);
        }
        for(String vote: votes){
            for(int pos=0; pos < n; pos++){
                char team = vote.charAt(pos);
                map.get(team)[pos]++; 
            }
        }

        List<Character> teams = new ArrayList<>(map.keySet());

        Collections.sort(teams, (a,b) -> {
            int[] countA = map.get(a);
            int[] countB = map.get(b);

            for(int i=0; i<n; i++){
                if(countA[i] != countB[i]){
                    return countB[i] - countA[i];
                }
            }
            return a-b;
        });

        StringBuilder sb = new StringBuilder();
        for(char c: teams) sb.append(c);
        return sb.toString();
    }
}
