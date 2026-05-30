package finalproject2; 
 
 

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
 
private String AdmissionDate;
private String AcademicStatus;
private List<Enrollment> enrolledCourses;

    public Student(String AdmissionDate, String AcademicStatus, String username, String password, String id, String name, String email, String contactInfo) {
        super(username, password, id, name, email, contactInfo);
        this.AdmissionDate = AdmissionDate;
        this.AcademicStatus = AcademicStatus;
        this.enrolledCourses = new ArrayList<> ();
    }

    @Override
    protected void displaySpecificDetails() {
        System.out.println("Student Details");
        System.out.println("Admission Date: " + AdmissionDate);
        System.out.println("Enrolled Courses: " + enrolledCourses.size());  
    }
public void registerForCourse(Course course){
    if (course.getAvailableSeats() > 0) {
        if (course.isPrerequisiteSatisfied(this)) {
            Enrollment e = new Enrollment(this, course);
            enrolledCourses.add(e);
            course.addStudent(this);
            System.out.println("Enrolled successfully.");
        } else {
            System.out.println("Prerequisites not satisfied.");
        }
    } else {
        System.out.println("Course is full.");
    }
}
      public void dropCourse(Course course){
          Enrollment Remove = null;
          for(Enrollment e :enrolledCourses){
           if(e.getCourse().equals(course)){
              Remove = e;
              break;
           }   
          }
          if(Remove!=null){
              enrolledCourses.remove(Remove);
              course.removeStudent(this);
              System.out.println("course is droped");
          }else{
              System.out.println("student isn't enrolled in this course");
          }
      }
      public void ViewGrades(){
          System.out.println("GRADES");
          for(Enrollment e: enrolledCourses){
            System.out.println("Course:" + e.getCourse().getTitle());
              System.out.println(e.getGrade());
          }
      }
     
      public double CalculateGPA() {
    double totalPoints = 0.0;
    int totalCreditHours = 0;
    
    for (Enrollment e : enrolledCourses) {
        if (e.getGrade() > 0) {  // Only count courses with assigned grades
            totalPoints += e.getGrade() * e.getCourse().getCreditHours();
            totalCreditHours += e.getCourse().getCreditHours();
        }
    }
    if (totalCreditHours == 0) {
    return 0.0;
} else {
    return totalPoints / totalCreditHours;
}
      }      
      

    public String getAdmissionDate() {
        return AdmissionDate;
    }

    public String getAcademicStatus() {
        return AcademicStatus;
    }

    public List<Enrollment> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setAdmissionDate(String AdmissionDate) {
        this.AdmissionDate = AdmissionDate;
    }

    public void setAcademicStatus(String AcademicStatus) {
        this.AcademicStatus = AcademicStatus;
    }

    public void setEnrolledCourses(List<Enrollment> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

@Override
public String toString() {
    return "Student[ID=" + getId() + ", Name=" + getName() + ", Email=" + getEmail() + 
           ", AdmissionDate=" + AdmissionDate + ", AcademicStatus=" + AcademicStatus + "]";
}
 
}