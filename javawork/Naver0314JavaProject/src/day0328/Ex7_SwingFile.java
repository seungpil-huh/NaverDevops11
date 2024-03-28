package day0328;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex7_SwingFile extends JFrame {
	
	JButton btnOpen, btnSave;
	JTextArea memoArea;
	
	public Ex7_SwingFile(String title) {
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
		JPanel p = new JPanel();
		btnOpen = new JButton("파일 열기");
		btnSave = new JButton("파일 저장");
		p.add(btnOpen);
		p.add(btnSave);
		
		// 프레임의 상단에 추가
		this.add("North", p);
		
		// 메모장은 가운데에 추가
		memoArea = new JTextArea();
		//this.add("Center", memoArea); // 메모장 크기보다 큰 내요을 불러올 경우 안보인다
		this.add("Center", new JScrollPane(memoArea)); // 메모장 크기보다 큰 내용을 불러올 경우 스크롤이 생긴다
		
		// 파일 열기 이벤트
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 파일 다이얼로그 (열기모드)
				FileDialog dlg = new FileDialog(Ex7_SwingFile.this, "파일 열기", FileDialog.LOAD);
				dlg.setVisible(true); // 다이얼로그 보이게 하기
				
				if (dlg.getDirectory() == null) {
					return; // 취소 클릭 시 이벤트 종료
				}
				String path = dlg.getDirectory() + dlg.getFile(); // 불러올 파일은 디렉토리명 + 파일명
				
				FileReader fr = null;
				BufferedReader br = null;
				
				try {
					fr = new FileReader(path);
					br = new BufferedReader(fr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						br.close();
						fr.close();
					} catch (IOException|NullPointerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		// 파일 저장 이벤트
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog dlg = new FileDialog(Ex7_SwingFile.this, "파일 저장", FileDialog.SAVE);
				dlg.setVisible(true);
				
				if (dlg.getDirectory() == null) {
					return;
				}
				String path = dlg.getDirectory() + dlg.getFile();
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(path);
					fw.write(memoArea.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex7_SwingFile a = new Ex7_SwingFile("간단 메모장");
	}

}
