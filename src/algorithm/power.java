package algorithm;

public class power {
	
	public static void main(String []args){
		System.out.println( countTrailingZerosOfFactorial(100));
	}
	
	public static int countTrailingZerosOfFactorial(int n) {
	    int count = 0;
	    for (int powerOfFive = 5; n / powerOfFive > 0; powerOfFive *= 5) {
	    	System.out.println(n/powerOfFive);
	        count += n / powerOfFive;
	    }
	    return count;
	}

}
