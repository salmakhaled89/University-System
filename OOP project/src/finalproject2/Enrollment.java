 package finalproject2;
 
 
public class Enrollment {
    private Student student;
    private Course course;
    private String enrollmrntDate;
    private double grade;
    private String status;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Enrollment(Student student, Course course, String enrollmrntDate, double grade, String status) {
        this.student = student;
        this.course = course;
        this.enrollmrntDate = enrollmrntDate;
        this.grade = grade;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getEnrollmrntDate() {
        return enrollmrntDate;
    }

    public double getGrade() {
        return grade;
    }

    public String getStatus() {
        return status;
    }
    
    public void asignGrade(double grade) {
    if (grade >= 0 && grade <= 4.0) {
        this.grade = grade;
        this.status = "Completed";
    } else {
        if (grade < 0 || grade > 4.0) {
    System.err.println("Invalid grade value received: " + grade);
} else {
    this.grade = grade;
    this.status = "Completed";
}
    }
    }

    
    public void withdraw(){
        setStatus("Withdrawn");
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setEnrollmrntDate(String enrollmrntDate) {
        this.enrollmrntDate = enrollmrntDate;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

@Override
public String toString() {
    return "Enrollment[StudentID=" + student.getId() + ", CourseID=" + course.getCourseId() + 
           ", Date=" + enrollmrntDate + ", Grade=" + grade + ", Status=" + status + "]";
}
}