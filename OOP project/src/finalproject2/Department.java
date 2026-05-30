 package finalproject2;
 
import java.util.ArrayList;
import java.util.List;
public class Department {
    private String departmentId;
    private String name;
    private List<Faculty>faculty;
    private List<Course>offeredCourses;

    public Department() {
        this.faculty = new ArrayList<>();
        this.offeredCourses = new ArrayList<>();
    }

    public Department(String departmentId, String name, List<Faculty> faculty, List<Course> offeredCourses) {
        this.departmentId = departmentId;
        this.name = name;
        this.faculty = new ArrayList<>();
        this.offeredCourses = offeredCourses;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public List<Faculty> getFaculty() {
        return faculty;
    }

    public List<Course> getOfferedCourses() {
        return offeredCourses;
    }

    public void setFaculty(List<Faculty> faculty) {
        this.faculty = faculty;
    }

    public void setOfferedCourses(List<Course> offeredCourses) {
        this.offeredCourses = offeredCourses;
    }
    
    
    public void addFaculty(Faculty facultyMember){
        faculty.add(facultyMember);
        System.out.println("Added Faculty: " + facultyMember.getName()+ "To Department: " + name);
    }
    public void removeFaculty(Faculty facultyMember){
        faculty.remove(facultyMember);
        System.out.println("Removed Faculty: " + facultyMember.getName() + "From Department: " + name);
    }
    public void addCourse(Course course){
        offeredCourses.add(course);
        System.out.println("Added Course: " + course.getTitle() + "To Department: " + name);
    } 
    
    public List<Faculty>getFacultyList(){
        return faculty;
    }

@Override
public String toString() {
    return "Department[ID=" + departmentId + ", Name=" + name + ", FacultyCount=" + faculty.size() +
           ", CoursesCount=" + offeredCourses.size() + "]";
}
    
}
