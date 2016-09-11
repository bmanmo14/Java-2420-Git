package assign10;

import java.util.ArrayList;
import java.util.Scanner;

public class GradesCS {
	
	
	
	public static double getHomeworkGrade(){
		double homework = 0.0;
		double homeworkTotal = 0.0;
		double homeworkFinalGrade = 0.0;
		System.out.println("How many homework grades do you have to enter?");
		Scanner a = new Scanner(System.in);
		int b = a.nextInt();
		if(b == 0){
			return 0.5;
		}
		System.out.println("Great, enter them now.");
		for(int i = 0; i < b; i++){
			System.out.println("What did you get?");
			homework+= a.nextDouble();
			System.out.println("What was it out of?");
			homeworkTotal += a.nextDouble();
		}
		homeworkFinalGrade = (homework/homeworkTotal)*0.5;
		
		return homeworkFinalGrade;
	}
	public static double getLabGrade(){
		double lab = 0.0;
		double labTotal = 0.0;
		double labFinalGrade = 0.0;
		System.out.println("How many lab grades do you have to enter?");
		Scanner a = new Scanner(System.in);
		int b = a.nextInt();
		if(b == 0){
			return 0.10;
		}
		System.out.println("Great, enter them now.");
		for(int i = 0; i < b; i++){
			System.out.println("What did you get?");
			lab+= a.nextDouble();
			System.out.println("What was it out of?");
			labTotal += a.nextDouble();
		}
		labFinalGrade = (lab/labTotal)*0.10;
		
		return labFinalGrade;
	}
	public static double getMidtermGrade(){
		double midterm = 0.0;
		double midtermTotal = 0.0;
		double midtermFinalGrade = 0.0;
		System.out.println("How many midterm grades do you have to enter?");
		Scanner a = new Scanner(System.in);
		int b = a.nextInt();
		if(b == 0){
			return 0.25;
		}
		System.out.println("Great, enter them now.");
		for(int i = 0; i < b; i++){
			System.out.println("What did you get?");
			midterm+= a.nextDouble();
			System.out.println("What was it out of?");
			midtermTotal += a.nextDouble();
		}
		midtermFinalGrade = (midterm/midtermTotal)*0.25;
		
		return midtermFinalGrade;
	}
	public static double getFinalGrade(){
		double finalTest = 0.0;
		double finalTestTotal = 0.0;
		double finalTestFinal = 0.0;
		System.out.println("How many final grades do you have to enter?");
		Scanner a = new Scanner(System.in);
		int b = a.nextInt();
		if(b == 0){
			return 0.15;
		}
		System.out.println("Great, enter them now.");
		for(int i = 0; i < b; i++){
			System.out.println("What did you get?");
			finalTest+= a.nextDouble();
			System.out.println("What was it out of?");
			finalTestTotal += a.nextDouble();
		}
		finalTestFinal = (finalTest/finalTestTotal)*0.15;
		
		return finalTestFinal;
	}
	
	public static void main(String[] args) {
		double totalGrade = 0.0;
		totalGrade += getHomeworkGrade();
		totalGrade += getLabGrade();
		totalGrade += getMidtermGrade();
		totalGrade += getFinalGrade();
		System.out.println("My grade is: " + totalGrade *100.0);

	}

}
