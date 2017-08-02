package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonEvent extends JFrame{

	public ButtonEvent() {
		super("람다 연습");
		setBounds(200, 200, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		JButton btn = new JButton("button1");
		btn.setBounds(10, 50, 100, 50);
		add(btn);
		
		btn.addActionListener(new ActionListener() {	//전통적 방법
			@Override
			public void actionPerformed(ActionEvent e) {
				setTitle("버튼 누름");
				
			}
		});
		
		JButton btn2 = new JButton("button2");
		btn2.setBounds(10, 150, 100, 50);
		add(btn2);
		btn2.addActionListener(e -> setTitle("버튼 클릭"));	//람다를 사용	
	}
	
	public static void main(String[] args) {
		new ButtonEvent();

	}

}
