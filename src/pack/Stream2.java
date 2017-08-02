package pack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

import pack.Stream1.Student;

public class Stream2 {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길동","남", 23),
				new Student("한가해","여", 25),
				new Student("고길동","남", 27),
				new Student("이기자","여", 33),
				new Student("한국인","남", 28)
			);
		//컬렉션, 배열 자료에 대한 중간, 최종 집계
		double avgM = list.stream()
					.filter(m -> m.getGender().equals("남"))
					.mapToInt(Student :: getAge)
					.average()
					.getAsDouble();
		System.out.println("남자 나이 전체 평균은 " + avgM);
		
		System.out.println();
		list.stream().filter(a -> a.getName().startsWith("한")).forEach(a -> System.out.println(a.getName()));
		
		System.out.println();
		List<String> list2 = 
				Arrays.asList("홍길동", "홍두깨", "홍길동", "신길동");
		list2.stream().distinct().forEach(a -> System.out.println(a));
		
		System.out.println();
		list2.stream().distinct().filter(a->a.startsWith("홍")).forEach(a -> System.out.println(a));
		
		System.out.println();
		list2.stream().sorted().forEach(a -> System.out.println(a));
		System.out.println();
		list2.stream().sorted(Comparator.reverseOrder()).forEach(a -> System.out.println(a));
		
		System.out.println();
		//숫자 처리
		int[] intArr = {2,4,6,9};
		boolean b = Arrays.stream(intArr).allMatch(a->a%2==0);
		System.out.println("모두 2의 배수? " + b);
		
		System.out.println();
		b = Arrays.stream(intArr).anyMatch(a -> a % 3 ==0);
		System.out.println("3의 배수가 있느냐? " + b);
		
		System.out.println();
		long res = Arrays.stream(intArr).filter(n -> n % 2 ==0).count();
		System.out.println("짝수의 개수: " + res);
		
		System.out.println();
		int res1 = Arrays.stream(intArr).filter(n -> n % 2 ==0).sum();
		System.out.println("짝수의 합: " + res1);
	}
	
	static class Student{
		private String name;
		private int age;
		private String gender;
		
		public Student(String name, String gender, int age) {
			this.name = name;
			this.age = age;
			this.gender = gender;
		}
		
		public String getName() {
			return name;
		}
		public String getGender() {
			return gender;
		}
		public int getAge() {
			return age;
		}
	}

}
