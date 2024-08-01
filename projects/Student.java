import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Student {

  private String firstName; 
  private String lastName; 
  private int yearOfStudy; 
  private String studentID; 
  private String modules; 
  private static double balance = 0; 
  private static int costOfModule = 600; 
  private static int id; 

  //Constructor Student (user enters student name and year of study)

  public Student() {
    Scanner scan = new Scanner (System.in); 

    System.out.print("Enter student First Name: ");
    this.firstName = scan.nextLine(); 

    System.out.print("Enter student Last Name: ");
    this.lastName = scan.nextLine(); 

    System.out.print("Enter year of study: ");
    this.yearOfStudy = scan.nextInt();
    scan.nextLine();   

    setStudentID();
    enroll();
    System.out.println(firstName + lastName + "\nStudent ID: " + studentID);
    
  }

  //Generate an ID (year of study + four random numbers )
  private void setStudentID(){
    Random rand = new Random(); 
    String digits = String.format("%04d", rand.nextInt(10000)); 
    this.studentID = yearOfStudy + "-" + digits; 
  }
   

  //Enroll in modules

  public void enroll(){

    
    do {
      System.out.print("Choose student modules. Your choices are: \n1. English \n2.Maths \n3.Physics \n4.History" +
       "\n5. Coding \n6. Chemistry. \nEnter a module name to enroll (or q to quit): ");
    
    Scanner scan = new Scanner(System.in);
    String course = scan.nextLine();
      if (!course.equals("q")) {
        balance += 600; 
        modules = modules +"\n" + course ;} 
       else {break;} 
      } while (2 != 1);
    }

  //view oustanding balance -> $600 per course enrolled 
  public void viewBalance(){
    System.out.println("Outstanding balance is: $" + balance);
  }

//makes a payment -> balance - payment 
  public void payTuition() {
    Scanner scan = new Scanner(System.in); 
    System.out.println("Would you like to make a payment towards tuition? Y or N");
    String userIn = scan.nextLine(); 
    if (userIn.equals("Y")) {System.out.println("How much would they like to pay?");
    double payment = scan.nextDouble(); 
    balance = balance - payment;
    System.out.println("Thank you for the payment");
    viewBalance();}  
    else {System.out.println("Ooutstanding balance has not changed");
    viewBalance();}
     
    
  }
   

  //Show status 
  public String info() {
    return "\nStudent Information" + "\n" +
    "\nFirst Name: " + this.firstName + "\n" 
            +  "Last Name: " + this.lastName + "\n"
            +  "Year of Study: " + this.yearOfStudy + "\n"
            +  "Student ID: " + this.studentID + "\n"
            +  "Enrolled in: " + this.modules + "\n"
            + "Outstanding Balance: $" + Student.balance + "\n";

  }
  
}