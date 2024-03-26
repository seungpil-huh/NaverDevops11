package day0326;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex17_ExceptionMunje {
    
    static final String FILENAME = "C:\\naver0314\\score.txt";
    
    public static void readScore() {
        int count = 0;
        int totalSum = 0;
        double average = 0.0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int score = Integer.parseInt(line);
                    totalSum += score;
                    count++;
                } catch (NumberFormatException e) {
                    //e.printStackTrace();
                }
            }
            
            if (count > 0) {
                average = (double) totalSum / count;
            }
            
            System.out.println("개수: " + count + "개");
            System.out.println("총점: " + totalSum);
            System.out.printf("평균: %.2f\n", average);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        readScore();
    }
}
