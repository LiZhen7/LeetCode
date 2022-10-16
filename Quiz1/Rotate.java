package Quiz1;

public class Rotate {
	
	public static int[] rotate(int[] arr, int k) {
		int n = arr.length;
		k = k % n;
		reverse(arr, 0, n - 1);
		reverse(arr, 0, k - 1);
		reverse(arr, k, n - 1);
		return arr;
	}
	
	public static void reverse(int[] arr, int start, int end) {
		while(start < end) {
			int tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5};
		rotate(arr, 3);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(",");
		}

	}

}
