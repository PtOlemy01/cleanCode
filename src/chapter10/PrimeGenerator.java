package chapter10;

import java.util.ArrayList;

public class PrimeGenerator {
    private static int[] primes;
    private static ArrayList<Integer> multiplesOfPrimeFactors;

    protected static int[] generate(int n){
        primes = new int[n];
        multiplesOfPrimeFactors = new ArrayList<>();
        set2AsFirstPrime();
        checkOdNumbersForSubsequentPrimes();
        return primes;
    }

    private static void set2AsFirstPrime(){
        primes[0] = 2;
        multiplesOfPrimeFactors.add(2);
    }

    private static void checkOdNumbersForSubsequentPrimes(){
        int primeIndex =1;
        for(int candidate = 3; primeIndex < primes.length; candidate += 2){
            if(isPrime(candidate))
                primes[primeIndex++] = candidate;
        }
    }

    private static boolean isPrime(int candidate){
        if(isLeastRelevantMultipleOfNextLargePrimeFactor(candidate)){
            multiplesOfPrimeFactors.add(candidate);
            return false;
        }
        return isNotMultipleOfAnyPreviousPrimeFactor(candidate);
    }

    private static boolean isLeastRelevantMultipleOfNextLargePrimeFactor(int candidate){
        int nextLargePrimeFactor = primes[multiplesOfPrimeFactors.size()];
        int leastRelevantMultiple = nextLargePrimeFactor * nextLargePrimeFactor;
        return candidate == leastRelevantMultiple;
    }

    private static boolean isNotMultipleOfAnyPreviousPrimeFactor(int candidate){
        for(int n = 1; n < multiplesOfPrimeFactors.size(); n++){
            if(isMultipleOfNthPrimeFactor(candidate, n))
                return false;
        }
        return true;
    }

    private static boolean isMultipleOfNthPrimeFactor(int candidate, int n){
        return candidate == smallOddNthMultipleNotLessThanCandidate(candidate, n);
    }

    private static int smallOddNthMultipleNotLessThanCandidate(int candidate, int n){
        int multiple = multiplesOfPrimeFactors.get(n);
        while(multiple < candidate)
            multiple += 2 * primes[n];
        multiplesOfPrimeFactors.set(n, multiple);
        return multiple;
    }

}
