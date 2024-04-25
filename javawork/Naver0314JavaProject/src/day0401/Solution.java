package day0401;

import java.util.Arrays;

class Solution {
    private static int[] solution(int[] arr) {
    	int[] clone = arr.clone();
    	Arrays.sort(clone);
    	System.out.println(Arrays.toString(arr));
    	return clone;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] arr = {1, -5, 2, 4, 3};
    	
    	System.out.println(Arrays.toString(sol.solution(arr)));
	}
}
