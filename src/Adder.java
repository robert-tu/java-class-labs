public class Adder
{
	private int a;
	private int intSum;
	
	public Adder()
	{
		a = 0;
		intSum = 0;
	}
	
	public Adder(int b)
	{	
		intSum = a + b;
	}
	public Adder add(int b)
	{
		intSum += b;
		return new Adder(intSum);
	}
	
	public int getA()
	{
		return a;
	}
	
	public void setA(int a)
	{
		this.a = a;
	}

	public int getIntSum()
	{
		return intSum;
	}
	
}