public class testAdder
{
	public static void main(String[] args)
	{
		int a = 1;
		Adder adder = new Adder(a);
	
		System.out.println(adder.add(1).add(1).add(1).getIntSum());
	}

}