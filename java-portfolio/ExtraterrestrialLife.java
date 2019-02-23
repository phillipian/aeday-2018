/**
 * @author Anthony Kim
 * Calculating the Possibility of Extraterrestrial Life Lab
 * Due Date: Oct. 31, 2018
 * 
 * Uses object-oriented programming to use a modified version of the Drake equation to 
 * estimate the theoretical number of planets in the Milky Way and the universe with 
 * extraterrestrial life. 
 */

import java.util.Scanner;

public class ExtraterrestrialLife
{
  private double habitPlanet; //private variables for encapsulation
  private double lifePlanet;
  private double intelLife;
  private double techCivil;
  final double NUM_STARS = 2.3E11;
  final double FRAC_STARS = 0.9;
  final double FRAC_GOLDILOCKS = 0.23;
  final double NUM_GALAXIES = 1.7E11;
  
  ExtraterrestrialLife(double habitPlanet, double lifePlanet, double intelLife, double techCivil) //constructor for instance variables
  {
    this.habitPlanet = habitPlanet;
    this.lifePlanet = lifePlanet;
    this.intelLife = intelLife;
    this.techCivil = techCivil;
  }
  
  double nmw()  //calculates the number of planets with life in the Milky Way
  {
    double numberMW = NUM_STARS * FRAC_STARS * FRAC_GOLDILOCKS * habitPlanet * lifePlanet;
    return numberMW;
  }
  
  double nimw() //calculates the number of planets in the Milky Way with technologically advanced intelligent life
  {
    double numberIMW = nmw() * intelLife * techCivil;
    return numberIMW;
  }
  
  double nu() //calculates the number of planets with life in the universe
  {
    double numberU = nmw() * NUM_GALAXIES;
    return numberU;
  }
  
  double niu()  //calculates the number of planets in the universe with technologically advanced intelligent life
  {
    double numberIU = nimw() * NUM_GALAXIES;
    return numberIU;
  }

  public static void main(String[] args)
  {
    System.out.println("CALCULATIONS FOR EXTRATERRESTRIAL LIFE BASED ON A MODIFIED DRAKE EQUATION\n");
    
    Scanner fraction = new Scanner(System.in);  //instantiate object for Scanner class
    
    System.out.print("Enter an estimated fraction for planets with habitable conditions (value within 0 to 1): ");
    double habitPlanet = fraction.nextDouble();
    
    if(habitPlanet < 0 || habitPlanet > 1)  //checks if user-input value is less than 0 or greater than 1 and stops program if otherwise
    {
      System.out.println("\t!!Please enter a valid fraction!!");
      return;
    }
        
    System.out.print("Enter an estimated fraction for habitable planets where life exists (value within 0 to 1): ");
    double lifePlanet = fraction.nextDouble();
    
    if(lifePlanet < 0 || lifePlanet > 1)
    {
      System.out.println("\t!!Please enter a valid fraction!!");
      return;
    }
    
    System.out.print("Enter an estimated fraction for planets where intelligent life may develop from life (value within 0 to 1): ");
    double intelLife = fraction.nextDouble();
    
    if(intelLife < 0 || intelLife > 1)
    {
      System.out.println("\t!!Please enter a valid fraction!!");
      return;
    }
    
    System.out.print("Enter an estimated fraction for planets where intelligent life may develop technological civilizations (value within 0 to 1): ");
    double techCivil = fraction.nextDouble();
    
    if(techCivil < 0 || techCivil > 1)
    {
      System.out.println("\t!!Please enter a valid fraction!!");
      return;
    }
    
    System.out.println("\nAssumptions for Calculation: ");
    System.out.println("\tFraction of planets with habitable conditions: " + habitPlanet);
    System.out.println("\tFraction of habitable planets where life exists: " + lifePlanet);
    System.out.println("\tFraction of planets where intelligent life arises: " + intelLife);
    System.out.println("\tFraction of planets where intelligent life develops into technological civilizations: " + techCivil);
    
    ExtraterrestrialLife obj = new ExtraterrestrialLife(habitPlanet, lifePlanet, intelLife, techCivil); //instantiating objects for the ExtraterrestrialLife class
    
    System.out.println("\nCalculated Results: ");
    System.out.println("\tThe number of planets with life that have existed in the Milky Way is: " + (int)obj.nmw());
    System.out.println("\tThe number of planets with technological life that have existed in the Milky Way is: " + (int)obj.nimw());
    System.out.println("\n\tThe number of planets with life that have existed in the Universe is: " + obj.nu());
    System.out.println("\tThe number of planets with technological life that have existed in the Universe is: " + obj.niu());
  }
}
