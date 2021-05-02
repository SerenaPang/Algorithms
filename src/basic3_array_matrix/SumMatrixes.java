package basic3_array_matrix;

public class SumMatrixes {
	
	public static int[][] sum(int[][]mat1, int[][]mat2){
		int row = mat1.length;
		int col = mat1[0].length;
		
		int[][] result = new int[row][col];
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col;c++) {
				result[r][c] = mat1[r][c] + mat2[r][c];
			}
		}		
		return result;
	}
	
	public static void main(String[] args) {
		int[][] mat1 = {{4,8},{3,7}};
		int[][] mat2 = {{1,0},{5,2}};
		TraceOfMatrix.print(mat1);
		TraceOfMatrix.print(mat2);
		System.out.println();
		TraceOfMatrix.print(sum(mat1, mat2));
		
	}
}
