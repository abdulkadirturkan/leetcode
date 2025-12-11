class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> rows = new HashMap<>();
        Map<Integer, TreeSet<Integer>> cols = new HashMap<>();
        for(int[] b : buildings){
            int x = b[0], y = b[1];
            rows.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
            cols.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }

        int count = 0;

        for(int[] b : buildings){
            int x = b[0], y = b[1];

            TreeSet<Integer> rowSet = rows.get(x);
            TreeSet<Integer> colSet = cols.get(y);

            boolean hasLeft = rowSet.lower(y) != null;
            boolean hasRight = rowSet.higher(y) != null;

            boolean hasAbove = colSet.lower(x) != null;
            boolean hasBelow = colSet.higher(x) != null;

            if(hasLeft && hasRight && hasAbove && hasBelow){
                count++;
            }
        }

        return count;
    }
}
