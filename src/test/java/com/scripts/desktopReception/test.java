package com.scripts.desktopReception;

public class test {

	/*public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		test obj = new test();
		obj.m(new String("test"));
		obj.m(new Object());
		obj.m(null);
	}*/

	public void m(Object  a)
	{
		System.out.println(a);
	}
	
	public Object m()
	{
		return null;
		//System.out.println("string a" +a);
	}
}

class b extends test {
	
	public String m()
	{
		System.out.println("test b");
//		return 0;
		return null;
	}
	
	
}