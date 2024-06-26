package day0327;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Ex5_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * List: 인터페이스를 구현한 클래스 중 하나
		 * LIFO 방식: 먼저 들어간게 나중에 나오는 방식
		 */
		Stack<String> stack1 = new Stack<String>();
		//List<String> stack1 = new Stack<String>(); // push 는 오버라이드 메소드가 아님
		stack1.push("사과");
		stack1.push("바나나");
		stack1.push("사과");
		stack1.push("오렌지");
		stack1.push("딸기");
		
		System.out.println("총 개수: " + stack1.size());
		
		while (!stack1.isEmpty()) {
			System.out.println(stack1.pop()); // 마지막으로 추가한 딸기가 먼저 출력됨
		}
		
		Queue<String> queue1 = new LinkedList<String>();
		queue1.offer("사과");
		queue1.offer("바나나");
		queue1.offer("사과");
		queue1.offer("오렌지");
		queue1.offer("딸기");
		
		System.out.println("\n총 개수: " + queue1.size());
		
		while (!queue1.isEmpty()) {
			System.out.println(queue1.poll());
		}
	}

}
