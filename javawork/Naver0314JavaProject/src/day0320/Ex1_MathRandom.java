package day0320;

public class Ex1_MathRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("** Math.random()을 이용한 난수 구하기 **");
		System.out.println("1. random()시 값 ");
		for(int i = 1;i<=5;i++) {
			double d = Math.random(); // 0.0 ~ 1.0 사이의 난수 발생
			System.out.print(d);
		}
		System.out.println();
		System.out.println("=".repeat(30));
		
		System.out.println("2. 0~9 발생");
		for(int i = 1;i<=5;i++) {
			int d = (int)(Math.random()*10); // 0.0 ~ 1.0 사이의 난수 발생
			System.out.printf("%4d",d);
		}
		
		System.out.println();
		System.out.println("=".repeat(30));
		
		System.out.println("3. 1~10 발생");
		for(int i = 1;i<=5;i++) {
			int d = (int)(Math.random()*10)+1; 
			System.out.printf("%4d",d);
		}
		
		System.out.println();
		System.out.println("=".repeat(30));
		
		System.out.println("4. 1~100 발생");
		for(int i = 1;i<=5;i++) {
			int d = (int)(Math.random()*100)+1; 
			System.out.printf("%4d",d);
		}
		
		
		System.out.println();
		System.out.println("=".repeat(30));
		System.out.println("5. 65(A)~90(Z) 발생");
		for(int i = 1;i<=5;i++) {
			int d = (int)(Math.random()*26)+65;
			System.out.printf("%4c",(char)d);
		

	}
		System.out.println();
		System.out.println("=".repeat(30));
		System.out.println("5. 97(a)~122(z) 발생");
		for(int i = 1;i<=5;i++) {
			int d = (int)(Math.random()*26)+97;
			System.out.printf("%4c",(char)d);
		

	}

}
}
