package numsDegree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组 nums， 数组的度的定义是指数组里任一元素出现频数的最大值。 
 * 你的任务是在 nums中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 */

class Solution {
	public int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> dict = new HashMap<>();
		int l = nums.length;
		// 数组任意元素出现频数
		for (int i = 0; i < l; i++) {
			if (dict.containsKey(nums[i])) {
				int temp = dict.get(nums[i]) + 1;
				dict.put(nums[i], temp);
			} else {
				dict.put(nums[i], 1);
			}
		}
		
		// 得到数组的度,和频数最大元素
		int degree = 0;
		ArrayList<Integer> de = new ArrayList<Integer>();
		for (Integer key : dict.keySet()) {
			if (dict.get(key) > degree) {
				degree = dict.get(key);
				de.clear();
				de.add(key);
			} else if (dict.get(key) == degree) {
				de.add(key);
			}
		}
		
		// 每个频数最大元素对应最短连续子数组长度
		int result = l;
		for (int j = 0; j < de.size(); j++) {
			int cur = de.get(j);
			int start = -1, end = 0, count = 0;
			for (int i = 0; i < l; i++) {
				if (nums[i] == cur && start < 0) {
					start = i;
					count++;
				} else if (nums[i] == cur) {
					count++;
				}
				if (count == degree) {
					end = i + 1;
					break;
				}
			}
			
			if (end - start < result) {
				result = end - start;
			}
		}

		return result;
	}
	public static void main(String[] args){
		int[] test = {1,2,2,3,1};
		Solution s = new Solution();
		s.findShortestSubArray(test);
	}
}
