package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
    private List<List<Integer>> ans;
    
    public List<List<Integer>> subsets(int[] nums) {
        this.ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        backtrack(nums, new ArrayList<>(), 0);
        return ans;
    }
    
    public void backtrack(int[] nums, List<Integer> sub, int start) {
        if(start == nums.length) return;
        for(int i = start; i < nums.length; i++) {
            sub.add(nums[i]);
            ans.add(new ArrayList<>(sub));
            backtrack(nums, sub, i + 1);
            sub.remove(sub.size() - 1);
        }
    }

}
