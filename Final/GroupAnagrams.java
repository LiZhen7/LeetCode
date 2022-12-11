package Final;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ans = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for(String str : strs) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String sorted = new String(arr);
			map.putIfAbsent(sorted, new ArrayList<>());
			map.get(sorted).add(str);
		}
		for(String key : map.keySet()) {
			ans.add(map.get(key));
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
		String[] str1 = {""};
		List<List<String>> ans = groupAnagrams(str1);
		for(List<String> sub : ans) {
			for(String s : sub) {
				System.out.println(s);
			}
			System.out.println("->");
		}

	}
	//T:O(nklogk) n = strs.length, k = length of longest string in strs

}
