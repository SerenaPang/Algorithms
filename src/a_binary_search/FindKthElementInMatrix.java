package a_binary_search;

public class FindKthElementInMatrix {
	
	//1 3 4
	//5 6 7
	//8 9 10
	//kIndex = 4, return 6 
	//6是第4个index
	public int findElement(int[][] matrix, int indexK) {
		int row = indexK / matrix[0].length;
		int col = indexK % matrix[0].length;
		return matrix[row][col];		
	}
}
