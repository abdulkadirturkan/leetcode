class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(List.of(1));

        if(numRows == 1) return triangle;

        for(int r = 2; r <= numRows; r++){
            List<Integer> prev = triangle.get(triangle.size() - 1);
            List<Integer> row = new ArrayList<>();

            row.add(1);

            for(int i = 1; i < prev.size(); i++){
                row.add(prev.get(i - 1) + prev.get(i));
            }

            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
}
