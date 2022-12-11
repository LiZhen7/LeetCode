package Final;

public class ValidParentheses {
	
	public static String validParentheses(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(char c : s.toCharArray()) {
			if(c == '(') {
				sb.append(c);
				count++;
			}else if(c == ')') {
				if(count > 0) {
					sb.append(c);
					count--;
				}
			}else {
				sb.append(c);
			}
		}
		if(count > 0) {
			for(int i = sb.length() - 1; i >= 0; i--) {
				if(sb.charAt(i) == '(') {
					sb.deleteCharAt(i);
					count--;
				}
				if(count == 0) break;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str1 = "lee(t(c)o)de)";
		String str2 = "a)b(c)d";
		String str3 = "))((";
		System.out.println(validParentheses(str1));
		System.out.println(validParentheses(str2));
		System.out.println(validParentheses(str3));
		// TODO Auto-generated method stub

	}
	//T:O(n)

}
