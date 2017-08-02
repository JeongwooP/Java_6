package pack;

public class MyLambda {
	static class Inner implements MyInter{
		@Override
		public int addData(int a, int b) {
			//전통적 방식
			return a + b;
		}
	}
	public static void main(String[] args) {
		Inner inner = new Inner();
		System.out.println(inner.addData(3, 4));

		System.out.println();
		MyInter myInter = (x, y) -> x + y;	//람다식 적용
		System.out.println(myInter.addData(3, 4));
		
		MyInter myInter2 = (x, y) -> x * y;	//람다식 적용
		System.out.println(myInter2.addData(3, 4));
		 
	}
	
	
	
	
}
