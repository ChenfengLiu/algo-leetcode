package pac1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 6, 11, 15, 7 };
		int[] nums2 = { 3, 2, 4 };
		System.out.println(Arrays.toString(twoSumArray(nums, 9)));
		System.out.println(Arrays.toString(twoSumHashMap(nums, 9)));

	}

	public static int[] twoSumArray(int[] arr, int sum) {
		int target;
		for (int i = 0; i < arr.length; i++) {
			target = sum - arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (target == arr[j]) {
					return new int[] { i, j };
				}
			}
		}
		return new int[2];
	}

	public static int[] twoSumHashMap(int[] arr, int sum) {
		Map<Integer,Integer> map = new HashMap<>();
		int target;
		for(int i = 0; i < arr.length; i++){
			target = sum - arr[i];
			if(map.containsKey(target)){
				return new int[]{map.get(target),i};
			}
			map.put(arr[i], i);
		}
		return new int[2];
	}

}
