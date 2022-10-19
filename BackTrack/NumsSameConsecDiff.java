package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class NumsSameConsecDiff {
    
    public int[] numsSameConsecDiff(int n, int k) {
    	List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            backtrack(n, k, 1, i, ans);
        }
        return ans.stream().mapToInt(j->j).toArray();
    }
    
    public void backtrack(int n, int k, int index, int num, List<Integer> ans) {
        if(index == n) {
            ans.add(num);
            return;
        }
        int lastDigit = num % 10;
        if(lastDigit + k < 10) {
            backtrack(n, k, index + 1, num * 10 + lastDigit + k, ans);
        }
        if(k != 0 && lastDigit - k >= 0) {
            backtrack(n, k, index + 1, num * 10 + lastDigit - k, ans);
        }
    }

}
