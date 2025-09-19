import java.util.Scanner;
public class ClassAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int total = 0;
        int gradeCounter = 0;

        System.out.println("輸入完成請按ctrl-z (Windows) 或 ctrl-d (Mac/Linux)結束輸入");

        while (input.hasNext()) {
            int grade = input.nextInt();
            total += grade;
            gradeCounter++;
        }

        if (gradeCounter != 0) {
            double average = (double) total / gradeCounter;
            System.out.printf("總分: %d%n", total);
            System.out.printf("成績數: %d%n", gradeCounter);
            System.out.printf("成績數: %.2f%n", average);
        } else {
            System.out.println("沒有輸入任何成績");
        }

    }
}