package pack;

public class MyInterMain {

	public static void main(String[] args) {
		// 1. 인자가 없는 추상 메소드 처리
		MyInterface interface1 = new MyInterface() {
			
			@Override
			public void abc() {
				System.out.println("일반적인 익명클래스의 메소드 오버라이딩");
				
			}
		};
		
		interface1.abc();
		
		//람다식으로 표현
		MyInterface interface2 = () -> {System.out.println("람다식으로 표현");};
		interface2.abc();
		
		System.out.println();
		MyInterface interface3 = () -> {
			int kbs = 9;
			System.out.println("kb2:" + kbs);
			System.out.println("공영방송");
		};
		
		interface3.abc();
		
		System.out.println();
		MyInterface interface4 = () -> System.out.println("람다식으로 표현2");
		interface4.abc();
		
		
		// 2.인자가 있는 추상 메소드 처리
		MyInterArg interArg = new MyInterArg() {
			
			@Override
			public void def(int a, int b) {
				System.out.println("두 수의 합은 " + (a + b));
				
			}
		};
		interArg.def(3, 4);
		
		MyInterArg interArg2 = (a, b) -> System.out.println("2 수의 합은 " + (a + b));
		interArg2.def(5, 6);
//		MyInterArg interArg2 = (a) -> System.out.println(a);
//		MyInterArg interArg2 = a -> System.out.println(a);
	
		System.out.println();
		// 3. 반환값이 있는 추상 메소드 처리
		MyInterArgOther argOther = new MyInterArgOther() {
			
			@Override
			public int def(int a, int b) {
				// TODO Auto-generated method stub
				return a + b;
			}
		};
		int result = argOther.def(3, 4);
		System.out.println("result : " + result);
		
		//람다식으로 표현
		MyInterArgOther argOther2 = (a, b) -> {return a + b;};
		int result2 = argOther2.def(3, 2);
		System.out.println("result2 : " + result2);
	
		MyInterArgOther argOther3 = (a, b) ->  a + b;
		int result3 = argOther2.def(3, 2);
		System.out.println("result3 : " + result3);
	
	}
	
	

}
