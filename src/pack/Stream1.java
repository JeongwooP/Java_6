package pack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {
	
	static int hap = 0;

	public static void main(String[] args) {
		List<String> list = Arrays.asList("마우스", "키보드", "모니터");
		
		Iterator<String> iter = list.iterator();	//외부 반복자 사용
		while(iter.hasNext()){
			String ss = iter.next();
			System.out.println(ss);
		}
		
		System.out.println();
		for(String s:list){	//enhanced for 사용
			System.out.println(s);
		}
		
		System.out.println();
		//Stream : 저장된 자료를 람다식으로 처리 가능
		Stream<String> stream = list.stream();
		stream.forEach(ss -> System.out.println(ss));
		
		//컬렉션에서 스트림 얻기
		System.out.println();
		List<Student> list2 = Arrays.asList(
				new Student("홍길동", 23),
				new Student("고길동", 25),
				new Student("한길동", 27)
				);
		
		Stream<Student> stream2 = list2.stream();
		stream2.forEach(s -> {
			System.out.println(s.getName() + " " + s.getAge());
		});
		
		System.out.println();
		//배열에서 스트림 얻기
		String[] arr = {"봄", "여름", "가을", "겨울"};
		Stream<String> stream3 = Arrays.stream(arr);
		stream3.forEach(a -> System.out.print(a + " "));
		
		System.out.println();
		IntStream intStream = IntStream.range(1, 11);
//		IntStream intStream = IntStream.rangeClosed(1, 10);
		intStream.forEach(k -> {
			System.out.print(k + " ");
			hap += k;
		});
		System.out.println("\n합은 " + hap);
		
		System.out.println();
		//순차, 병렬 처리
		List<String> list3 = Arrays.asList("마우스", "키보드", "모니터", "기술이사", "몹쓸병");
		
		//순차
		Stream<String> seqStream = list3.stream();
//		seqStream.forEach(Stream1 :: printData);	//Stream1.printData()
		seqStream.forEach(s -> printData(s));
		
		System.out.println();
		//병렬 : ForkJoinPool을 사용. 쓰레드 풀 사용.
		Stream<String> parStream = list3.parallelStream();
		parStream.forEach(Stream1 :: printData);
	}
	
	static void printData(String str){
		System.out.println(str + " : " + Thread.currentThread().getName());
	}
	
	static class Student{
		private String name;
		private int age;
		
		public Student(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		public String getName() {
			return name;
		}
		
		public int getAge() {
			return age;
		}
	}
}
