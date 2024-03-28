package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ex5_SwingCanvas extends JFrame {
	// 캔버스 변수 선언
	MyDraw draw = new MyDraw();
	// 음식 사진 경로
	String foodImage = "C:\\naver0314\\workall\\image\\음식사진\\11.jpg";
	String foodImage2 = "C:\\naver0314\\workall\\image\\음식사진\\1.jpg";
	
	public Ex5_SwingCanvas(String title) {
		super(title);
		this.setLocation(1300, 200); // 시작위치
		this.setSize(500, 500); // 창 크기
		//this.getContentPane().setBackground(new Color(93, 199, 187)); // 배경색 변경
		//this.getContentPane().setBackground(Color.yellow);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 (이 코드를 넣어야 프레임 창을 종료할 때 컴파일러도 종료된다)
		this.initDesign(); // 각종 컴포넌트 생성
		this.setVisible(true); // 보이게 하기
	}
	
	// 캔버스를 상속받는 내부클래스
	class MyDraw extends Canvas {
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			// 색상 변경
			g.setColor(Color.magenta);
			// 테두리만 있는 타원 그리기
			g.drawOval(30, 30, 100, 100);
			// 채워진 타원
			g.setColor(Color.orange);
			g.fillOval(150, 30, 100, 100);
			
			// 테두리만 있는 사각형
			g.setColor(new Color(8, 207, 7));
			g.drawRect(30, 150, 100, 100);
			
			// 채워진 사각형
			g.setColor(new Color(239, 136, 190));
			g.fillRect(150, 150, 100, 100);
			
			// 글꼴 출력
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			g.drawString("Good Day!!", 50, 350);
			
			g.setFont(new Font("궁서체", Font.BOLD, 30));
			g.drawString("안녕하세요!!", 250, 350);
			
			// 음식 이미지 그리기 방법 #1
			Image image1 = new ImageIcon(foodImage).getImage();
			g.drawImage(image1, 300, 10, 130, 130, this);
			
			// 음식 이미지 그리기 방법 #2
			Image image2 = Toolkit.getDefaultToolkit().getImage(foodImage2);
			g.drawImage(image2, 300, 150, 130, 130, this);
		}
	}
	
	public void initDesign() {
		// 기본 레이아웃의 Center 에 캔버스를 추가
		this.add("Center", draw);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex5_SwingCanvas a = new Ex5_SwingCanvas("캔버스");
	}

}
