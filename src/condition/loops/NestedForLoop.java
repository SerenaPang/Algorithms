package condition.loops;

public class NestedForLoop {

		public static void main(String[] args) {
			for(int i = 0; i < 2; i++) { //i: 0 1  		
				int j = 0;
				for(j = 0; j < 5; j++) { 
					if(j == 2) {
						break;// j: 0 1
					}
					System.out.print(i + "," + j + " ");
				}
				/** breaking the outer loop
				if(j == 2) {
					break;
				}
				*/
			}
		}
}
