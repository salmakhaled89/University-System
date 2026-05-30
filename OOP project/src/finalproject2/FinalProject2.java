 package finalproject2;
 import java.util.*;

public class FinalProject2 {
      private static List<Course> courses;

    public static void main(String[] args) {
        
        FileManager fileManager =new FileManager();
        Scanner input = new Scanner(System.in);
        List<User>users = fileManager.loadUsers("users.txt");
        List<Student>students = fileManager.loadStudents("students.txt");
        List<Course>courses = fileManager.loadCourses("courses.txt", new ArrayList<>());
        List<Enrollment>enrollments = fileManager.loadEnrollments("enrollments.txt", students, courses);
        List<Department>departments = new ArrayList<>();
        
        while(true){
            System.out.println("Welcome To Our University Management System");
            System.out.println("Select an Option: ");
            System.out.println("1. View Users");
            System.out.println("2. Add User");
            System.out.println("3. View Students");
            System.out.println("4. Add Student");
            System.out.println("5. View Courses");
            System.out.println("6. Add course");
            System.out.println("7. Enroll Student in Course");
            System.out.println("8. Drop Course");
            System.out.println("9. Assign Grade (Faculty Only)");
            System.out.println("10. Calculate GPA for Student");
            System.out.println("11. View Students Grades");
            System.out.println("12. Calculate GPA");
            System.out.println("13. Exit");
            
            int Choice =-1;
            try{
                Choice = input.nextInt();
            }
            catch(java.util.InputMismatchException e){
                System.out.println("Invaid Input. please enter a number.");
                input.next();
                continue;
            }
            input.nextLine();
            
            
            switch(Choice){
                case 1:
                    System.out.println("Users: ");
                    for(User user : users){
                        System.out.println(user.getName() + " ("+ user.getUsername() +")");
                    }
                    break;
                case 2:
                    System.out.println("Enter UserName: ");
                    String username = input.nextLine();  
                    System.out.println("Enter Password: ");
                    String password = input.nextLine();
                    System.out.println("Enter ID: ");
                    String id = input.nextLine();
                    System.out.println("Enter Name: ");
                    String name = input.nextLine();
                    System.out.println("Enter Email: ");
                    String email = input.nextLine();
                    System.out.println("Enter Contact Info: ");
                    String contactInfo = input.nextLine();
                    
                    User newUser = new User(username, password, id, name, email, contactInfo){
                        @Override
                        protected void displaySpecificDetails(){
                        }
                    };
                    users.add(newUser);
                    fileManager.saveUsers(users, "users.txt");
                    System.out.println("User Added Successfully.");
                    break;
                    
                case 3:
                    System.out.println("Students:");
                    for(Student student : students){
                    System.out.println(student.getName() + "(" + student.getId() + ")");  
                    }
                    break;
                    
                case 4:
                    System.out.println("Enter UserName:");
                    String studentusername = input.nextLine();
                    System.out.println("Enter Password: ");
                    String studentpassword = input.nextLine();
                    System.out.println("Enter ID: ");
                    String studentId = input.nextLine();
                    System.out.print("Enter name: ");
                    String studentName = input.nextLine();
                    System.out.print("Enter email: ");
                    String studentEmail = input.nextLine();
                    System.out.print("Enter contact info: ");
                    String studentContactInfo = input.nextLine();
                    System.out.print("Enter admission date: ");
                    String admissionDate = input.nextLine();
                    System.out.print("Enter academic status: ");
                    String academicStatus = input.nextLine();
                    
                    Student newStudent = new Student(admissionDate,academicStatus,studentusername,studentpassword,studentId,studentName,studentEmail,studentContactInfo);
                    students.add(newStudent);
                    fileManager.saveStudents(students,"students.txt");
                    System.out.println("Student Added Successfully.");
                    break;
                    
                    
                case 5:
                    System.out.println("Courses:");
                    for(Course course : courses){
                        System.out.println(course.getTitle() + "(" + course.getCourseId() +")");
                    }
                    break;
                    
                case 6:
                    System.out.print("Enter course ID: ");
                    String courseId = input.nextLine();
                    System.out.print("Enter title: ");
                    String title = input.nextLine();
                    System.out.print("Enter description: ");
                    String description = input.nextLine();
                    System.out.print("Enter credit hours: ");
                    int creditHours = input.nextInt();
                    System.out.print("Enter maximum students: ");
                    int maxStudents = input.nextInt();
                    input.nextLine(); 
                    System.out.print("Enter schedule: ");
                    String schedule = input.nextLine();
                    
                    Course newCourse = new Course(courseId,title,description,creditHours,maxStudents,schedule,null);
                    System.out.println("Number Of Prerequiste course IDs to add:");
                    int numPrereqs = input.nextInt();
                    input.nextLine();
                    for(int i = 0 ; i<numPrereqs ; i++){
                        System.out.println("Enter Prerequiste course ID " + (i+1) + ":");
                        String prereqId = input.nextLine();
                        newCourse.getPrerequisites().add(prereqId);
                    }
                    courses.add(newCourse);
                    fileManager.saveCourses(courses,"courses.txt");
                    System.out.println("Course Added Successfully.");
                    break;

                    
                    
                case 7:
                 enrollStudent(input, students, courses);
                    break;

     
                    
                case 8:
                    dropCourse(input,students);
                    break;
                    
                case 9:
                        System.out.println("Enter Faculty Username: ");
                    String facultyUser = input.nextLine();
                System.out.println("Enter Faculty Password: ");
                 String facultyPass = input.nextLine();
    
    // Verify faculty credentials
                    Faculty faculty = verifyFacultyCredentials(users, facultyUser, facultyPass);
                   if (faculty == null) {
                 System.out.println("Invalid faculty credentials!");
                 break;
                }
    
    System.out.println("Enter Student ID: ");
    String gradeStudentId = input.nextLine();
    Student gradeStudent = findStudentById(students, gradeStudentId);
    
    if (gradeStudent == null) {
        System.out.println("Student not found!");
        break;
    }
    
    System.out.println("Enter Course ID: ");
    String gradeCourseId = input.nextLine();
    Course gradeCourse = findCourseById(courses, gradeCourseId);
    
    if (gradeCourse == null) {
        System.out.println("Course not found!");
        break;
    }
    
    System.out.println("Enter Grade (0.0-4.0): ");
    double gradeValue = input.nextDouble();
    input.nextLine(); // consume newline
    
    if (gradeValue < 0 || gradeValue > 4.0) {
        System.out.println("Invalid grade value!");
        break;
    }
    
    faculty.assignGrade(gradeStudent, gradeCourse, gradeValue);
    break;

    
                case 10:
                    System.out.println("Enter Student ID: ");
                    String gpaStudentId = input.nextLine();
              Student gpaStudent = findStudentById(students, gpaStudentId);
    
         if (gpaStudent == null) {
                  System.out.println("Student not found!");
                 break;
                  }
                 double gpa = gpaStudent.CalculateGPA();
                 System.out.println(gpaStudent.getName() + "'s GPA: " + Math.round(gpa * 100) / 100.0);
                     break;
                    
                case 11:
                    viewStudentGrades(input, students);
                    break;
                    
                case 12:
                    calculateGPA(input,students);
                    break;
                    
                case 13:
                    System.out.println("Exiting The System");
                   input.close();
                    return;
                    
                    
                    
                default:
                    System.out.println("Invalid option.");
            }
        }


        
    }
    private static void enrollStudent(Scanner input,List<Student> students,List<Course> courses){
        System.out.println("Enter Student ID: ");
        String studentId = input.nextLine().trim();
        Student student = findStudentById(students, studentId);
        if(student != null){
            System.out.println("Enter Course ID to Enroll: ");
            String courseId = input.nextLine();
            Course course = findCourseById(courses, courseId);
            if(course != null){
                if(course.getPrerequisites() == null){
                    course.setPrerequisites(new ArrayList<>());
                }
                student.registerForCourse(course);
                System.out.println("Student Enrolled in Course Successfully.");
            }
            else{
                System.out.println("Course not Found.");
            }
        }
        else{
            System.out.println("Student not Found.");
        }
    }
    
    
    
    
    private static void dropCourse(Scanner input, List<Student>students){
        System.out.println("Enter Student ID:");
        String studentId = input.nextLine().trim();
        Student student = findStudentById(students, studentId);
        if(student != null){
            System.out.println("Enter Course ID to drop: ");
            String courseId = input.nextLine();
            Course course = findCourseById(courses , courseId);
            if(course != null){
                student.dropCourse(course);
                System.out.println("Course Dropped Successfully.");
            }
            else{
                System.out.println("Course not Found.");
            }
            }
        else{
            System.out.println("Student not Found.");
        }
    }
    private static void viewStudentGrades(Scanner input, List<Student>students){
        System.out.println("Enter Student ID:");
        String studentId = input.nextLine().trim();
        Student student = findStudentById(students, studentId);
        if(student != null){
            student.ViewGrades();
        }
        else{
            System.out.println("Student not Found.");
        }
    }
    private static void calculateGPA(Scanner input, List<Student>students){
        String studentId = input.nextLine().trim();
        Student student = findStudentById(students, studentId);
        if(student != null){
            double gpa = student.CalculateGPA();
            System.out.println("GPA for " + student.getName() + ": " + gpa);
        }
        else{
         System.out.println("Student not Found.");
        }
    }
    private static Student findStudentById(List<Student> students, String id){
        if(id == null){
            return null;
        }
        for(Student student : students){
            if(student != null && id.equals(student.getId())){
                return student;
            }
        }
        return null;
    }
    private static Course findCourseById(List<Course> courses, String id){
       if(id == null){
           return null;
       }
        for(Course course : courses){
            if(course != null && id.equals(course.getCourseId())){
                return course;
            }
        }
        return null;
    }
    private static Faculty verifyFacultyCredentials(List<User> users, String username, String password) {
    for (User user : users) {
        if (user instanceof Faculty && 
            user.getUsername().equals(username) && 
            user.getPassword().equals(password)) {
            return (Faculty) user;
        }
    }
    return null;
}


}
