package basic3_array_matrix;

public class MatrixSizeGetter {

	public static void main(String[] args) {
		int m = 4; 
		int n = 6;
		
		int[][] matrix = new int[m][n];
		System.out.println("# of rows: " + matrix.length);
		System.out.println("# of columns: " + matrix[0].length);
	} 
}
