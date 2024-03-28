package day0328;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex4_SwingButton extends JFrame {
	
	JButton btn1, btn2;
	
	public Ex4_SwingButton(String title) {
		super(title);
		this.setLocation(1500, 200); // 시작위치
		this.setSize(300, 300); // 창 크기
		this.getContentPane().setBackground(new Color(230, 199, 197)); // 배경색 변경
		//this.getContentPane().setBackground(Color.yellow);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 (이 코드를 넣어야 프레임 창을 종료할 때 컴파일러도 종료된다)
		this.initDesign(); // 각종 컴포넌트 생성
		this.setVisible(true); // 보이게 하기
	}
	
	public void initDesign() {
		this.setLayout(null); // 기본 레이아웃 없애기
		// 버튼 1 생성
		btn1 = new JButton("버튼 1");
		// 프레임에 추가
		btn1.setBounds(10, 10, 100, 30); // x, y, w, h
		this.add(btn1);
		// btn1 에 이벤트 추가 - 익명 내부클래스 형태로 이벤트 구현
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(Ex4_SwingButton.this, "첫번째 버튼을 눌렀어요!");
			}
		});
		
		// 버튼 2 생성 후 프레임에 추가해보세요
		btn2 = new JButton("버튼 2");
		btn2.setBounds(150, 10, 100, 30);
		this.add(btn2);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(Ex4_SwingButton.this, "두번째 버튼을 눌렀어요!");
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_SwingButton a = new Ex4_SwingButton("스윙버튼");
	}

}
