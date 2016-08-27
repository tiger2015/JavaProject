package test3;

public class Test {
	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		int k = 0;
		for (int z = 0; z < 5; z++) {
			if ((++x > 2) && (++y > 2) && (k++ > 2)) {
				x++;
				++y;
				k++;
			}
			System.out.println(x + "" + y + "" + k);
		}
		System.out.println(x + "" + y + "" + k);
		
		System.out.println(++x>5);
		
		Integer s=new Integer(9);
		Integer t=new Integer(9);
		System.out.println(s==t);//比较的是地址
		System.out.println(s.equals(t));//比较的是值
		s=12;//s=new Integer(12);自动装箱
		System.out.println(t);
		
	}
}