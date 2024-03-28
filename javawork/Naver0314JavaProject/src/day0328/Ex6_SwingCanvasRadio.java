package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class Ex6_SwingCanvasRadio extends JFrame {
	
	final static String PHOTO1 = "C:\\naver0314\\workall\\image\\연예인사진 (2)\\19.jpg"; //수지
	final static String PHOTO2 = "C:\\naver0314\\workall\\image\\연예인사진 (2)\\18.jpg"; //신세경
	final static String PHOTO3 = "C:\\naver0314\\workall\\image\\연예인사진 (2)\\15.jpg"; //설현
	final static String PHOTO4 = "C:\\naver0314\\workall\\image\\연예인사진 (2)\\2.jpg"; //김우빈
	
	Color boxColor = new Color(67, 196, 207); // 초기 박스 색상
	JRadioButton rbBox1, rbBox2, rbBox3, rbBox4;
	JRadioButton rbPhoto1, rbPhoto2, rbPhoto3, rbPhoto4;
	int photoIndex = 1; // 처음에 수지 사진
	
	MyDraw draw = new MyDraw();
	
	public Ex6_SwingCanvasRadio(String title) {
		super(title);
		this.setLocation(1300, 200); // 시작위치
		this.setSize(400, 500); // 창 크기
		//this.getContentPane().setBackground(new Color(93, 199, 187)); // 배경색 변경
		//this.getContentPane().setBackground(Color.yellow);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 (이 코드를 넣어야 프레임 창을 종료할 때 컴파일러도 종료된다)
		this.initDesign(); // 각종 컴포넌트 생성
		this.setVisible(true); // 보이게 하기
	}
	
	// 캔버스 내부클래스
	class MyDraw extends Canvas {
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			// 채워진 박스 그리기
			g.setColor(boxColor);
			g.fillRect(30, 70, 320, 320);
			
			Image image = null;
			switch (photoIndex) {
			case 1:
				image = new ImageIcon(PHOTO1).getImage();
				break;
			case 2:
				image = new ImageIcon(PHOTO2).getImage();
				break;
			case 3:
				image = new ImageIcon(PHOTO3).getImage();
				break;
			case 4:
				image = new ImageIcon(PHOTO4).getImage();
				break;
			}
			g.drawImage(image, 80, 100, 220, 260, this);
		}
	}
	
	public void initDesign() {
		this.add("Center", draw);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex6_SwingCanvasRadio a = new Ex6_SwingCanvasRadio("캔버스2");
	}

}
