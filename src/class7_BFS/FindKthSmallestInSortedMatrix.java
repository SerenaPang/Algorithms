package class7_BFS;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * The matrix rows and columns are both in ascending order
 * Find the kth smallest element in the matrix
 * */
public class FindKthSmallestInSortedMatrix {
	//Since we want kth smallest number, we need to put k size heap to find it out 	
	//create a priority queue with initial size of k, and take in a comparator that order the priority queue
	public static int findKthSmallest(int[][] matrix, int k) {
		PriorityQueue<Cell> minHeap = new 
	            PriorityQueue<Cell>(k, new CellComparator());
		//Cell constructor: row, column, cell value
		//Populating the min heap
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		//mark the node that's already been generated so we avoid repeated generate the same node
		boolean[][] visited = new boolean[rowLen][colLen];
		//put the first number to the heap and mark it as visited
		minHeap.offer(new Cell(0,0,matrix[0][0]));
		visited[0][0] = true;
		System.out.println();
		for(int i = 0; i < k - 1; i++) {
			System.out.println("第" + i + "轮：");
			//get the head of the queue and remove it
			Cell cur = minHeap.poll();
			System.out.println("Polling " + cur.value + " at " + "[" +  + cur.row + "]"+ "[" +  + cur.cloumn + "]");
			//A visit down move向下看:
			//if the cell in the lower level is not out of boundary to the bottom and the cell in the lower level
			//has not been visited, then we add it to the min heap and mark it as visited cell
			if(cur.row + 1 < rowLen && !visited[cur.row + 1][cur.cloumn]) {
				//add this cell to the min heap
				minHeap.offer(new Cell(cur.row + 1,cur.cloumn, matrix[cur.row + 1][cur.cloumn]));
				System.out.println("Offering " + matrix[cur.row + 1][cur.cloumn]+ " at " + "[" +  + (cur.row + 1) + "]"+ "[" +  + cur.cloumn + "]");
				visited[cur.row + 1][cur.cloumn] = true;
			}
			//向右看
			//same operation that we check when going to the right, it's not out of boundary and it has not been visited
			if(cur.cloumn + 1 < colLen && !visited[cur.row][cur.cloumn + 1]) {
				//add this cell to the min heap
				minHeap.offer(new Cell(cur.row, cur.cloumn + 1, matrix[cur.row][cur.cloumn + 1]));
				System.out.println("Offering " + matrix[cur.row][cur.cloumn + 1]+ " at " + "[" +  + cur.row + "]"+ "[" +  + (cur.cloumn + 1) + "]");
				visited[cur.row][cur.cloumn + 1] = true;
			}
			System.out.println("Current Min Heap: ");
			printHeap(minHeap);
			System.out.println();
		}
		System.out.println();
		System.out.println("Print boolean matrix: ");
		printMatrix(visited);
		System.out.println();	
		return minHeap.peek().value;
	}
	
	/**
	 * This is the min heap with all elements in the matrix
	 * */
	public static void printOriginalHeap(int[][] matrix) {
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		int size = rowLen * colLen - 1;
		
		PriorityQueue<Cell> minHeap = new 
	            PriorityQueue<Cell>(size, new CellComparator());
		//Cell constructor: row, column, cell value
		
		//populating all Cells to the min heap
		for(int row = 0; row < rowLen; row++) {
			for(int col = 0; col < colLen; col++) {
			//	System.out.print(matrix[i][j] + " ");
				minHeap.offer(new Cell(row, col, matrix[row][col]));
			}
			//System.out.println();
		}
		//print
		 while(!minHeap.isEmpty()) {
             System.out.print(minHeap.peek().value + " ");
             minHeap.poll();
     }
     System.out.println();
	}
	
	public static void printHeap(PriorityQueue<Cell> minHeap) {
		PriorityQueue<Cell> copy = new PriorityQueue<>(minHeap); 
	        while(!copy.isEmpty()) {
	                System.out.print( copy.poll().value + " ");
	               
	        }
	        System.out.println();
	}
	
	
	public static void printMatrix(int[][] matrix) {
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		for(int i = 0; i < rowLen; i++) {
			for(int j = 0; j < colLen; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printMatrix(boolean[][] matrix) {
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		for(int i = 0; i < rowLen; i++) {
			for(int j = 0; j < colLen; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
			{1,2,3,5,6},
			{2,3,4,6,8},
			{3,4,5,7,9},
			{4,5,6,8,10},
			{5,6,9,10,11}
		};
		System.out.println("Matrix: ");
		printMatrix(matrix);
		System.out.println("Print min Heap for the matrix");
		printOriginalHeap(matrix);

		int kth = 7;
		int result = findKthSmallest(matrix, kth);
		System.out.println("The " + kth + "th smallest element is " + result);
	}
}
