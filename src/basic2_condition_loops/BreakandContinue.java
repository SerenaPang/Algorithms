package basic2_condition_loops;

public class BreakandContinue {
	
	public static void infiniteLoop() {
		int i = 0;
		while(i < 10) {
			if(i == 5) {
				continue; // when i == 5, skip it
			}
			System.out.print(i + " ");
			i++; // because when we skip 5, we skip these 
			//2 sentences as well, so i will never get increment again and it will never 
			//be 5
		}
	}
	
	public static void normalLoop() {
		int i = -1;
		while(i < 9) {
			i++; //put i++ before continue so it won't skip the increment
			if(i == 5) {
				continue;
			}
			System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) {
		//continue: skip the current one but continue on the next one
		
		int i;
		for(i = 0; i < 10; i++) {
			if(i == 5) {
				continue; // will skip 5
			}
			System.out.print(i + " ");
		}
		System.out.println();
		
		//break: stop at the current one and that's it
		for(i = 0 ; i < 10; i++) {
			if(i == 5) {
				break;//will stop when i ==  5
			}
			System.out.print(i + " ");
		}
		
		System.out.println();
		//infiniteLoop();
		normalLoop();
	}
}
