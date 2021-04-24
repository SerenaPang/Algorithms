package class5_0409;

public class SearchInSortedMatrix {
	//search a target number in an array
	public static int[] search(int[][] matrix, int target) {
		int[] result = {-1, -1};
		if(matrix == null || matrix.length == 0) {
			return result;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		
		int left = 0;
		int right = m * n - 1;
		
		while(left <= right) {
			int mid = left + (right - left)/2;
			if(target == matrix[mid / n][mid % n]) {
				result[0] = mid / n;
				result[1] = mid % n;
				return result;
			}else if(target < matrix[mid / n][mid % n]) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}	
		return result;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,3},{4,5,7},{8,9,10}};
		
	}
}
