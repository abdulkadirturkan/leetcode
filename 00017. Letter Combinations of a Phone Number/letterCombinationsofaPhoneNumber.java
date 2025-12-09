class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;

        String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, 0, new StringBuilder(), result, map);
        return result;
    }

    private void backtrack(String digits, int idx, StringBuilder path, List<String> result, String[] map){
        if(idx == digits.length()){
            result.add(path.toString());
            return;
        }

        String letters = map[digits.charAt(idx) - '0'];

        for(char c : letters.toCharArray()){
            path.append(c);
            backtrack(digits, idx + 1, path, result, map);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
