package day0401;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
    		int[] sortedArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
        	Arrays.sort(sortedArr);
        	
        	result[i] = sortedArr[commands[i][2] - 1];
		}
        
        return result;
    }
    
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		System.out.println(Arrays.toString(sol.solution(array, commands)));
	}
}
