package a_binary_search;

public class SortedMatrix {
	
	public static void print(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				//System.out.println(" " + matrix[i][j] + " ");
				//index of the element
				//target = 3 -> index: 2 
				//System.out.println("row: " + 2/col +  "col: " + 2%col + " ");
				System.out.println("row: " + 4/col +  "col: " + 4%col + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] sortedMatrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
		print(sortedMatrix);
	}
}
