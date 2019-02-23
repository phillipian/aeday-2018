/**
 * @author Anthony Kim
 * Sieve of Eratosthenes Lab
 * Jan. 25, 19
 * 
 * Executes the algorithm of Sieve of Eratosthenes to to find 
 * what numbers up to the value of N are prime. Uses the Arrays and ArrayList
 * classes to allow for two different applications of the algorithm.
 */


import java.util.ArrayList; //importing ArrayList, Arrays, and Scanner classes
import java.util.Arrays;
import java.util.Scanner;

public class PrimeSieveLab
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in); //instantiate Scanner class
    
    System.out.println("This program will find all primes between 2 and integer N.");
    System.out.println("Enter an integer value for N > 2: ");
    int maxRange = input.nextInt(); //accepts user input for max range value
    
    System.out.println();
    
    System.out.println("Which method would you like to use to compute the primes? [Select 1 or 2]");
    System.out.println("[1] Computation using Arrays");
    System.out.println("[2] Computation using ArrayLists");
    int listType = input.nextInt(); //accepts user input for using either arrays or ArrayLists
    
    System.out.println();
    
    System.out.println("Would you like to print the prime numbers? [Select 1 or 2]");
    System.out.println("[1] Yes");
    System.out.println("[2] No");
    int print = input.nextInt();  //accepts user input for printing the resulting prime numbers
    
    long startTime = System.currentTimeMillis();  //starts timer
    
    System.out.println();
    
    if(listType == 1) //if user inputs 1, use arrays
    {
      arrayAlg(maxRange, print);
    }
    else if(listType == 2)  //if user inputs 2, use ArrayLists
    {
      arrayListAlg(maxRange, print);
    }
    
    input.close();
    
    System.out.println();
    
    long stopTime = System.currentTimeMillis(); //stop timer
    long runTime = (stopTime - startTime);  //calculates total time
    System.out.println("Execution time: " + runTime + " milliseconds.");
  }
  
  public static void arrayAlg(int rangeVal, int printDecide)
  {
    boolean primeList[] = new boolean[rangeVal + 1];  //creates an array of length (rangeVal + 1)
    int counter = 0;  //counter for counting number of prime numbers   
    
    primeList[0] = false; //0 and 1 are both not prime
    primeList[1] = false;
    
    for(int a = 2; a < primeList.length; a++) //initially sets all other numbers as prime
    {
      primeList[a] = true;
    }
    
    for(int i = 2; i < primeList.length; i++)
    {
      for(int j = 2; i*j <= rangeVal; j++)  //marks all composite numbers as not prime
      {
        primeList[i*j] = false;
      }
      
      if(printDecide == 1)  //if the user input was 1, print the array elements
      {
        if(primeList[i] == true)
        {
          System.out.println(i);
          counter++;  //counting the number of prime numbers
        }
      }
    }
    
    System.out.println("\nThere are " + counter + " prime numbers from 2 to " + rangeVal);    
  }
  
  public static void arrayListAlg(int rangeVal, int printDecide)
  {
    ArrayList<Integer> primeList = new ArrayList<Integer>();  //creating an ArrayList
    
    for(Integer a = 0; a <= rangeVal; a++)
    {
      primeList.add(a); //add numbers from 0 to rangeVal to the ArrayList
    }
    
    for(Integer i = 2; i < rangeVal; i++)
    {
      for(Integer j = 2; i*j <= rangeVal; j++)
      {
        Integer notPrime = i*j;
        primeList.remove(notPrime); //remove all composite numbers from the ArrayList
      }
    }
    
    primeList.remove(0);  //remove 0, which is not a prime
    primeList.remove(0);  //remove 1, which is also not a prime
    
    if(printDecide == 1)
    {
      System.out.println(primeList);  //if the user input was 1, print the ArrayList
    }
    
    System.out.println("\nThere are " + primeList.size() + " prime numbers from 2 to " + rangeVal);
  }
}
