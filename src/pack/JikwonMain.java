package pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//특정 클래스에 대한 메소드의 인자로 람다 사용
public class JikwonMain {
	static ArrayList<Jikwon> jikwons = new ArrayList<>();
	static{
		jikwons.add(new Jikwon(3, "홍길동", "111-1111"));
		jikwons.add(new Jikwon(1, "고길동", "222-1111"));
		jikwons.add(new Jikwon(2, "나길동", "333-1111"));
		System.out.println("정렬 전 : " + jikwons.toString());
	}
	public static void main(String[] args) {
		Collections.sort(jikwons, new Comparator<Jikwon>() {
			@Override
			public int compare(Jikwon o1, Jikwon o2) {
				return o1.bunho - o2.bunho;
			}
		});
		System.out.println("정렬결과1:" + jikwons);
		
		System.out.println();
		Collections.sort(jikwons, (o1, o2) -> o1.bunho - o2.bunho);
		System.out.println("정렬결과2:" + jikwons);
		
		//반복처리에서 람다 사용
		System.out.println();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 1; i < 100; i++){
			arr.add(i);
		}
		
		for(Integer i: arr){
			System.out.print(i);
			System.out.println();
		}
		
		System.out.println("람다로 출력");
		arr.forEach(i -> {
			System.out.print(i);
			System.out.println();
		});
	}

}
