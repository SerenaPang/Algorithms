package class3_0331;

public class TraceOfMatrix {
	
	public static void print(int[][]arr) {
		int row = arr.length;
		int col = arr[0].length;
		
		for(int r = 0; r < row;r++) {
			for(int c = 0; c < col; c++) {
				System.out.print(arr[c][r] + " ");
				//System.out.println();
			}
			System.out.println();
		}
	}
	
	public static int calculateTrace(int[][] matrix) {
		int result  = 0;
		for(int r = 0; r < matrix.length; r++) {
			result = result + matrix[r][r];
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		int[][] matrix = {{5,3,5},
						  {4,-1,2},
						  {-3, 8,7}
						  };
		print(matrix);
		
		int trace = calculateTrace(matrix);
		System.out.println("Trace: " + trace);
	}
}
