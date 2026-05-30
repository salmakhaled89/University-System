 package finalproject2;
 
 

import java.util.ArrayList;
public class Faculty extends User {
    private String Department;
    private String Expertises;
    private ArrayList<Course>Courses_Teaching;
    private int Office_Hours;
    private String Location;
     
    public Faculty(){
        
    }

    public Faculty(String Department, String Expertises, ArrayList<Course> Courses_Teaching, String Location, String username, String password, String id, String name, String email, String contactInfo) {
        super(username, password, id, name, email, contactInfo);
        this.Department = Department;
        this.Expertises = Expertises;
        this.Courses_Teaching = Courses_Teaching;
        this.Location = Location;
    }

 
    public String getDepartment() {
        return Department;
    }

    public String getExpertises() {
        return Expertises;
    }

    public ArrayList<Course> getCourses_Teaching() {
        return Courses_Teaching;
    }

    public int getOffice_Hours() {
        return Office_Hours;
    }

    public String getLocation() {
        return Location;
    }

    public void setOffice_Hours(int Office_Hours) {
        this.Office_Hours = Office_Hours;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public void setExpertises(String Expertises) {
        this.Expertises = Expertises;
    }

    public void setCourses_Teaching(ArrayList<Course> Courses_Teaching) {
        this.Courses_Teaching = Courses_Teaching;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

 
    
    
    @Override
    protected void displaySpecificDetails() {
        System.out.println("Department:" + getDepartment());
        System.out.println("Expertises: " +getExpertises() );
        System.out.println("Courses Teaching: " );
        getCourses_Teaching();
    }
    public void assignGrade(Student student, Course course, double grade) {
    for (Enrollment e : student.getEnrolledCourses()) {
        if (e.getCourse().equals(course)) {
            e.asignGrade(grade);
            System.out.println("Grade assigned successfully!");
            return;
        }
    }
    System.out.println("Student is not enrolled in this course");
}
    
    public void manageCourse(int maxstudent,String schedule){
        Course m=new Course();
        System.out.println("new max students: ");
         m.setMaxStudents(maxstudent);
         System.out.println("new schedule: ");
         m.setSchedule(schedule);
    }
    public void viewStudentRoster(Course course){
        System.out.println("Student in course: "+course.getTitle());
        for(Student st:course.getEnrolledStudents()){
            System.out.println("name: "+st.getName()+" "+"ID: "+st.getId());
        }
    }
    public void addToCourse(Course course){
        this.Courses_Teaching.add(course);
        course.setInstractor(this);
    }

    @Override
    public void generateReport(String report) {
        System.out.println("Faculty report:");
        System.out.println(report);
        
    }

    @Override
    public double calculatePayroll() {
        return Courses_Teaching.size()*3000;
    }
    
    
}
