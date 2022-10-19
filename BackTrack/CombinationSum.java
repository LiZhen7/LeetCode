package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
	 private List<List<Integer>> ans;
	    
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	     this.ans = new ArrayList<>();
	     backtrack(candidates, target, 0, 0, new ArrayList<>());
	     return ans;
	 }
	    
	 public void backtrack(int[] arr, int target, int sum, int index, List<Integer> sub) {
	     if(sum > target) {
	         return;
	     }else if(sum == target) {
	         ans.add(new ArrayList<>(sub));
	         return;
	     }
	        
	     for(int i = index; i < arr.length; i++) {
	         sum += arr[i];
	         sub.add(arr[i]);
	         backtrack(arr, target, sum, i, sub);
	         sum -= arr[i];
	         sub.remove(sub.size() - 1);
	     }
	 }

}
