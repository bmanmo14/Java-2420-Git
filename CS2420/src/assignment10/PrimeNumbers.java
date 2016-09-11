package assignment10;

public class PrimeNumbers {
	
	public static boolean isPrime(int num) {
	       if (num % 2 == 0) {
	    	   return false;
	       }
	       for (int i = 3; i * i <= num; i += 2){
	           if (num % i == 0){
	        	   return false;
	           }
	       }
	       return true;
	   }
	   
	   public static int nextPrime(int num){
		   int newPrime = 0;
		   for(int i = num+1; i < 2*num; i++){
			   if(isPrime(i)){
				   newPrime = i;
				   return newPrime;
			   }
		   }
		return newPrime;
	   }
}
