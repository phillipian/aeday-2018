public abstract class GCDAbstract
{

  private long a, b;

  GCDAbstract(long a, long b)
  {
    this.a = a;
    this.b = b;
  }

  // recursive helper method
  private long gcd(long a, long b)
  {
    if (b == 0)
      return a;
    else
      return gcd(b, a % b);
  }

  // driver method
  public long getGcd()
  {
    return gcd(this.a, this.b);
  }

  public long getA()
  {
    return this.a;
  }

  public long getB()
  {
    return this.b;
  }

  protected void setValidLongAB(char c, long x)
  {
    if (c == 'a')
      this.a = x;
    else if (c == 'b')
      this.b = x;
    else
      System.out.println("ERROR in method setValidLongAB: char not eligible value!");
  }

  public abstract void setA(long a);

  public abstract void setB(long b);

} // close abstract class