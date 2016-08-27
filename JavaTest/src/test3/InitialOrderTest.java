package test3;

import java.text.DecimalFormat;

public class InitialOrderTest {
	public static String sString = "静态变量";

	public String mString = "变量";
	
	public final String fString;

	static {
		System.out.println(sString);
		System.out.println("静态初始化块");
	}

	{
		System.out.println(mString);
		System.out.println("初始化块");
		//fString="ada";
	}

	public InitialOrderTest() {
		fString="ada";
		System.out.println("构造器");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		short s1=1;
	
		new InitialOrderTest();
		System.out.println(1+2);
		
		System.out.println(Math.round(-4.56d));
		DecimalFormat format=new DecimalFormat("0.00");
		System.out.println(format.format(-3.4445d));
		
	}

}
