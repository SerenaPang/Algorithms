package condition.loops;
//Every even integer greater than 2 can be expressed as the sum of 2 primes
public class GoldbachConjecture {
	
	public static void checkGoldbachConjecture(int limit) {
		
		for(int i = 4; i < limit; i +=2) {//2 4 6 8...(all even numbers to the limit)
			//System.out.println(i);
			if(isCounterExample(limit)) {
				System.out.println("Goldbach is wrong");
				break;
			}else {
				System.out.println("Goldbach is right");
			}
		}
		
	}
	
	//add 2 even numbers = a prime
	//check these 2 numbers
	//check if they are prime numbers
	private static boolean isCounterExample(int sum) {
		
		int num;
		for(int i = 2; i < sum/2; i++) {
			if(isPrime(i) && isPrime(sum - i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isPrime(int num) {
		if(num<2) {
			return false;
		}
		
		for(int i = 2; i * i <= num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int limit = 100;
		checkGoldbachConjecture(limit);
	}

}
