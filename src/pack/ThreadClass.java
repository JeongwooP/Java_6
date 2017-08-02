package pack;

import javax.xml.stream.events.StartDocument;

public class ThreadClass {
	public void sendEmail(String ss){
		System.out.println(ss + " 파일 전송");
	}
	
	public ThreadClass() {
		m1();
		m2();
		m3();
		m4();
	}
	
	void m1(){	//전통방식
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				sendEmail("m1");
				
			}
		}).start();
	}
	
	void m2(){	//람다 사용
		Thread thread = new Thread(() -> sendEmail("m2"));
		thread.start();
	}
	void m3(){	//람다 사용
		new Thread(() -> sendEmail("m3")).start();
		
	}
	void m4(){	//람다 사용
		Runnable runnable = () -> sendEmail("m4");;
		runnable.run();
	}
	public static void main(String[] args) {
		new ThreadClass();
	}

}
