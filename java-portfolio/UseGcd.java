class GcdSubclass extends GCDAbstract
{

  // Constructor
  GcdSubclass(long a, long b)
  {
    super(a, b);
  }

  @Override
  public void setA(long a)
  {
    if(a < 0)
      System.out.println("ERROR: a is less than 0");
    else
      setValidLongAB('a', a);
  }

  @Override
  public void setB(long b)
  {
    if(b < 0)
      System.out.println("ERROR: a is less than 0");
    else
      setValidLongAB('b', b);
  }

} // close subclass

public class UseGcd
{
  public static void main(String[] args)
  {
    long a = 459;
    long b = 527;
    GcdSubclass obj = new GcdSubclass(a, b);
    System.out.println(
        "The GCD of the values " + a + " and " + b + " is " + obj.getGcd());
  } // close main method
} // close public class
