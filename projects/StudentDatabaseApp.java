import java.util.Scanner;

public class StudentDatabaseApp {
  public static void main(String[] args) {

    //Ask how many students to add

    System.out.print("How many students would you like to register?");
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt(); 

    //Create the students 
    Student[] students = new Student[n]; 
    for (int i = 0; i < students.length; i++) {
      students[i] = new Student(); 
      students[i].enroll();
      students[i].payTuition();
      students[i].viewBalance();
      System.out.println(students[i].info());;
      ;
    }

    
    
  }
}