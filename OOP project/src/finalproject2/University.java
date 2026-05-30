 package finalproject2;
 
import java.util.ArrayList;
import java.util.List;
public class University {
   private List<Department>departments;
   private List<User>users;
   private List<Course>courses;

    public University() {
        this.departments = departments;
        this.users = users;
        this.courses = courses;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    
    
    
     public void registerStudent(Student student){
         users.add(student);
         System.out.println("Registered Student: " + student.getName());
     }
     public void hireFaculty(Faculty faculty){
         users.add(faculty);
         System.out.println("Hired Faculty: " + faculty.getName());
     }
     public void CreateDepartment(Department department){
         departments.add(department);
         System.out.println("Created Department: "+ department.getName());
     }
     public void OfferCourse(Course course){
         courses.add(course);
         System.out.println("Offered course: " + course.getTitle());
     }

     
    @Override
    public String toString() {
        return "University with "+ departments.size()+ "departments" + users.size() +"users" +courses.size() + "courses.";
        
    }  
}