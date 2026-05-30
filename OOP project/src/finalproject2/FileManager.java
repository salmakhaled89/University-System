package finalproject2;
 
import java.io.*;
import java.util.*;

public class FileManager {

    private String filename;

   
    public void saveStudents(List<Student> students, String filename) {
        File file = new File(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Student s : students) {
                writer.write(
                    s.getAdmissionDate() + "," +
                    s.getAcademicStatus() + "," +
                    s.getUsername() + "," +
                    s.getPassword() + "," +
                    s.getId() + "," +
                    s.getName() + "," +
                    s.getEmail() + "," +
                    s.getContactInfo()
                );
                writer.newLine();
            }
            System.out.println("Students saved successfully to: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

   
    public List<Student> loadStudents(String filename) {
        List<Student> students = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File not found: " + filename);
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 8) {
                    Student s = new Student(
                        data[0], data[1], data[2], data[3],
                        data[4], data[5], data[6], data[7]
                    );
                    students.add(s);
                }
            }
            System.out.println("Students loaded successfully from: " + filename);
        } catch (IOException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
        return students;
    }

   
    public void saveUsers(List<User> users, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (User u : users) {
                writer.write(
                    u.getUsername() + "," +
                    u.getPassword() + "," +
                    u.getId() + "," +
                    u.getName() + "," +
                    u.getEmail() + "," +
                    u.getContactInfo()
                );
                writer.newLine();
            }
            System.out.println("Users saved successfully to: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

 
    public List<User> loadUsers(String filename) {
        List<User> users = new ArrayList<>();
        if (!new File(filename).exists()) {
            System.out.println("File not found: " + filename);
            return users;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6) {
                    
                    User u = new User(data[0], data[1], data[2], data[3], data[4], data[5]) {
                        @Override
                        protected void displaySpecificDetails() {
                        }
                        
                    };
                    users.add(u);
                }
            }
            System.out.println("Users loaded successfully from: " + filename);
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        return users;
    }

    
    public void saveCourses(List<Course> courses, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Course c : courses) {
                writer.write(
                    c.getCourseId() + "," +
                    c.getTitle() + "," +
                    c.getDescription() + "," +
                    c.getCreditHours() + "," +
                    c.getMaxStudents() + "," +
                    c.getSchedule()
                );
                writer.newLine();
            }
            System.out.println("Courses saved successfully to: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }

    
    public List<Course> loadCourses(String filename, List<Faculty> facultyList) {
        List<Course> courses = new ArrayList<>();
        if (!new File(filename).exists()) {
            System.out.println("File not found: " + filename);
            return courses;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", 6);
                if (data.length >= 6) {
                  
                    Faculty instructor = facultyList.isEmpty() ? null : facultyList.get(0);
                    Course c = new Course(
                        data[0], data[1], data[2],
                        Integer.parseInt(data[3]),
                        Integer.parseInt(data[4]),
                        data[5], instructor
                    );
                    courses.add(c);
                }
            }
            System.out.println("Courses loaded successfully from: " + filename);
        } catch (IOException e) {
            System.out.println("Error loading courses: " + e.getMessage());
        }
        return courses;
    }

    
    public void saveEnrollments(List<Enrollment> enrollments, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Enrollment e : enrollments) {
                writer.write(
                    e.getStudent().getId() + "," +
                    e.getCourse().getCourseId() + "," +
                    e.getEnrollmrntDate() + "," +
                    e.getGrade() + "," +
                    e.getStatus()
                );
                writer.newLine();
            }
            System.out.println("Enrollments saved successfully to: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving enrollments: " + e.getMessage());
        }
    }

    
    public List<Enrollment> loadEnrollments(String filename, List<Student> students, List<Course> courses) {
        List<Enrollment> enrollments = new ArrayList<>();
        if (!new File(filename).exists()) {
            System.err.println("File not found: " + filename);
            return enrollments;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    Student student = findStudentById(students, data[0]);
                    Course course = findCourseById(courses, data[1]);
                    if (student != null && course != null) {
                        Enrollment e = new Enrollment(
                            student, course, data[2],
                            Double.parseDouble(data[3]),
                            data[4]
                        );
                        enrollments.add(e);
                    }
                }
            }
            System.out.println("Enrollments loaded successfully from: " + filename);
        } catch (IOException e) {
            System.out.println("Error loading enrollments: " + e.getMessage());
        }
        return enrollments;
    }

     
private Student findStudentById(List<Student> students, String id) {
for (Student s : students) {
if (s.getId().equals(id)) return s;
}
return null;
}
private Course findCourseById(List<Course> courses, String id) {
for (Course c : courses) {
if (c.getCourseId().equals(id)) return c;
}
return null;
}
}
