package BackTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {
	
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(digits, "", 0, map, ans);
        return ans;
    }
    
    public void dfs(String digits, String s, int position, Map<Character, String> map, List<String> ans) {
        if(position == digits.length()) {
            ans.add(s);
            return;
        }
        String curr = map.get(digits.charAt(position));
        for(char c : curr.toCharArray()) {
            dfs(digits, s + c, position + 1, map, ans);
        }
    }

}
