import java.util.Scanner;

public class Student {
        private String firstName;
        private String middleName;
        private String lastName;
        private String suffix;    
        private String fullName;

    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSuffix() {
        return suffix;
    }
    public String getFullName() {
        return fullName;
    }
    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

public static void main (String[] args) {
           Scanner scan = new Scanner(System.in) ;
           Student student = new Student();
   
               System.out.print("Input First Name: ");
               student.setFirstName(scan.nextLine());
               
               System.out.print("Input Middle Name: ");
               student.setMiddleName(scan.nextLine());
               
               System.out.print("Input Last Name: ");
               student.setLastName(scan.nextLine());
               
               System.out.print("Input Suffix: ");
               student.setSuffix(scan.nextLine());
               
               String fullName = student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName() + " " + student.getSuffix();
               student.setFullName(fullName);
            
               System.out.println("First Name: " + student.getFirstName());
               System.out.println("Middle Name: " + student.getMiddleName());
               System.out.println("Last Name: " + student.getLastName());
               System.out.println("Suffix: " + student.getSuffix());
               System.out.println("Full Name: " + student.getFullName());
           scan.close();
      }
   }