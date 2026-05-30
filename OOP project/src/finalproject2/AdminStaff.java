 package finalproject2;
 
import java.util.Scanner;
public class AdminStaff extends User {
    private String department;
    private String role;

    public AdminStaff() {
    }

    public AdminStaff(String department, String role, String username, String password, String id, String name, String email, String contactInfo) {
        super(username, password, id, name, email, contactInfo);
        this.department = department;
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

    @Override
    protected void displaySpecificDetails() {
        System.out.println("Department: "+getDepartment());
        System.out.println("Role: "+getRole());
    }

    @Override
    public void generateReport(String report) {
        System.out.println("Admin Staff report: ");
        System.out.println(report);
    }    
    public Student registerStudent(Scanner input) {
        System.out.println("adding Student");
        
        System.out.print("Username: ");
        String username = input.next();
        
        System.out.print("password: ");
        String password = input.next();
        
        System.out.print("ID: ");
        String studentId = input.next();
        
        System.out.print("name: ");
        input.nextLine();
        String name = input.nextLine();
        
        System.out.print("email: ");
        String email = input.next();
        
        System.out.print("contact information: ");
        String contact = input.next();
        
        System.out.print("admission data: ");
        String admissionDate = input.next();
        
        System.out.print(" Academic Status: ");
        String  AcademicStatus=input.next();
        
        Student newStudent=new Student(admissionDate, AcademicStatus,username,password, studentId , name,email,contact);
        
        return newStudent;
    }
    public Course createCourse(Scanner input, Faculty instructor) {
    System.out.println("Creating new course...");

    System.out.print("Course ID: ");
    String courseId = input.next();

    input.nextLine(); 
    System.out.print("Title: ");
    String title = input.nextLine();

    System.out.print("Description: ");
    String description = input.nextLine();

    System.out.print("Credit Hours: ");
    int creditHours = input.nextInt();

    System.out.print("Maximum Students: ");
    int maxStudents = input.nextInt();

    input.nextLine(); 
    System.out.print("Schedule : ");
    String schedule = input.nextLine();

    Course newCourse = new Course(courseId, title, description, creditHours, maxStudents, schedule, instructor);

    System.out.print("Number of prerequisite course IDs to add: "); 
    int numPrereqs = input.nextInt();
    input.nextLine();  

    for (int i = 0; i < numPrereqs; i++) {
        System.out.print("Enter prerequisite course ID " + (i + 1) + ": ");
        String prereqId = input.nextLine();
        newCourse.getPrerequisites().add(prereqId);
    }

    System.out.println("Course created successfully.");
    return newCourse;
}
 public void assignFaculty(Faculty faculty,Course course){
     faculty.addToCourse(course);
     System.out.println("done");
 }
     @Override
    public double calculatePayroll() {
        return 10000;
    }
}
