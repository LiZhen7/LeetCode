package Midterm;

public class Question5 {
	
	public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11};
        int[] values = {1,4,5,10};
        int[] output = getStartOfEachValues(arr, values);
        for(int num : output) {
        	System.out.print(num + ",");
        }
    }

    // arr = [0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11]
    // values = [1,4,5,10]
    // output = [5, -1, 12, 17]
    private static int[] getStartOfEachValues(int[] arr, int[] values){
        int[] indexes = new int[values.length];
        for(int i = 0; i < indexes.length; i++) {
        	indexes[i] = binarySearch(arr, values[i]);
        }

        return indexes;
    }
    
    private static int binarySearch(int[] arr, int target) {
    	int left = 0;
    	int right = arr.length - 1;
    	while(left <= right) {
    		int mid = left + (right - left)/2;
    		if(arr[mid] < target) {
    			left = mid + 1;
    		}else if(arr[mid] > target) {
    			right = mid - 1;
    		}else {
    			while(mid > 0 && arr[mid - 1] == target) {
    				mid--;
    			}
    			return mid;
    		}
    	}
    	return -1;
    }
    //Time complexity: O(nlogn)

}
