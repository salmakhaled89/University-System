 package finalproject2;
 
import java.util.*;
public class Course {
private String courseId;
    private String title;
    private String description;
    private int creditHours;
    private int maxStudents;
    private String schedule;
    private ArrayList<String> prerequisites;
    private ArrayList<Student> enrolledStudents;
    private Faculty instractor;

    public Course() {
        this.prerequisites=new ArrayList<>();
        this.enrolledStudents=new ArrayList<>();
    }

    public Course(String courseId, String title, String description, int creditHours, int maxStudents, String schedule, Faculty instractor) {
        this();
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.creditHours = creditHours;
        this.maxStudents = maxStudents;
        this.schedule = schedule;
        this.instractor = instractor;
    }

    
    
    
    
    
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public ArrayList<String> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(ArrayList<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(ArrayList<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Faculty getInstractor() {
        return instractor;
    }

    public void setInstractor(Faculty instractor) {
        this.instractor = instractor;
    }
    
    public void addStudent(Student student){
        if(enrolledStudents.size()<=maxStudents){
            enrolledStudents.add(student);
            System.out.println("Student is added");
        }

    }
      public void removeStudent(Student student){
          enrolledStudents.remove(student);
          System.out.println("Student is remved");
      }
      public int getAvailableSeats(){
          if(enrolledStudents == null){
              enrolledStudents = new ArrayList<>();
          }
          return(maxStudents-enrolledStudents.size());
      }
public boolean isPrerequisiteSatisfied(Student student) {
    List<Enrollment> completedCourses = student.getEnrolledCourses();
    List<String> completedCourseIds = new ArrayList<>();
    
    for (Enrollment e : completedCourses) {
        completedCourseIds.add(e.getCourse().getCourseId());
    }
    
    for (String prereqId : prerequisites) {
        if (!completedCourseIds.contains(prereqId)) {
            return false;
        }
    }
    return true;
}

@Override
public String toString() {
    return "Course[ID=" + courseId + ", Title=" + title + ", CreditHours=" + creditHours +
           ", Instructor=" + (instractor != null ? instractor.getName() : "None") + "]";
}
}

