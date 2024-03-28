package day0328;

import java.awt.Color;

import javax.swing.JFrame;

public class SwingGibon extends JFrame {
	
	public SwingGibon(String title) {
		super(title);
		this.setLocation(1300, 200); // 시작위치
		this.setSize(500, 500); // 창 크기
		//this.getContentPane().setBackground(new Color(93, 199, 187)); // 배경색 변경
		//this.getContentPane().setBackground(Color.yellow);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 (이 코드를 넣어야 프레임 창을 종료할 때 컴파일러도 종료된다)
		this.initDesign(); // 각종 컴포넌트 생성
		this.setVisible(true); // 보이게 하기
	}
	
	public void initDesign() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingGibon a = new SwingGibon("기본창");
	}

}
