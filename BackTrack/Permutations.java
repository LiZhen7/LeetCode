package BackTrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
	
    private List<List<Integer>> ans;
    
    public List<List<Integer>> permute(int[] nums) {
        this.ans = new ArrayList<>();
        Set<Integer> contain = new HashSet<>();
        backtrack(nums, new ArrayList<>(), contain);
        return ans;
    }
    
    public void backtrack(int[] nums, List<Integer> sub, Set<Integer> contain) {
        if(sub.size() == nums.length) {
            ans.add(new ArrayList<>(sub));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(contain.contains(nums[i])) continue;
            sub.add(nums[i]);
            contain.add(nums[i]);
            backtrack(nums, sub, contain);
            sub.remove(sub.size() - 1);
            contain.remove(nums[i]);
        }
    }

}
