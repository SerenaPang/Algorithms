package a_binary_search;

public class SearchInSortedMatrix {
	/*
	 * @param target is the target number
	 * 
	 * 
		//1 2 3
		//4 5 6
		//7 8 9
		 * target : 4 should return {1,0}
	 * */
	public int[] search(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			System.out.println(target + " target not found");
			return new int[] {-1,-1};
		}
		//define left right border
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		int left = 0;
		int right = rowLen * colLen - 1;
		
		//1 2 3
		//4 5 6
		//7 8 9
		
		//1 2 3 4 5 6 7 8 9 
		while(left <= right) {
			int mid = left + (right - left)/2;
			int rowIndex = mid/colLen;
			int colIndex = mid % colLen;
			if(matrix[rowIndex][colIndex] == target) {
				return new int[] {rowIndex, colIndex};
			}else if(matrix[rowIndex][colIndex] > target) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}	
		return new int[] {-1, -1};
	}
}
