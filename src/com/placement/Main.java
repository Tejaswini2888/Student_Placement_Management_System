package com.placement;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("================================================");
        System.out.println(" STUDENT PLACEMENT MANAGEMENT SYSTEM ");
        System.out.println("================================================");
        while(true){
        System.out.println();
        System.out.println("1.Student Management");
        System.out.println("2.Company Management");
        System.out.println("3.Placement Management");
        System.out.println("4.Reports");
        System.out.println("5.Exit");
        System.out.println("Enter your choice:");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                System.out.println("Student Management selected.");
                break;
            case 2:
                System.out.println("Company Management selected.");
                break;
            case 3:
                System.out.println("Placement Management selected.");
                break;
            case 4:
                System.out.println("Reports selected.");
                break;
            case 5:
                System.out.println("Thank you for using the system.");
                sc.close();
                return;
            default:
                System.out.println("Invalid choice. Please enter 1 to 5.");
        }
        }
    }
}
