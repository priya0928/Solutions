
import java.util.stream.*;
import java.util.*;
import java.lang.*;

public class PrimeNumber
{
	public static void main(String[] args) {		
		System.out.println(primeNumbersCount(10));		
	}
	
    private static int primeNumbersCount(int n) {
        List<Integer> primeNos = new ArrayList<>();
        if(n>=0 && n<=5*106){
            primeNos =  IntStream.rangeClosed(2, n)
                          .filter(x -> isPrime(x)).boxed()
                          .collect(Collectors.toList());
        }
        
        return primeNos.size();
    }
    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
          .allMatch(n -> number % n != 0);
    }
}
