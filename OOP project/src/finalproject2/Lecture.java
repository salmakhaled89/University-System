 package finalproject2;
 

public class Lecture extends Course {
    private String lectureHall;
    private boolean hasProjector;
    private int numberOfSections;

    public Lecture() {
        super();
    }

    public Lecture(String courseId, String title, String description, int creditHours,
                  int maxStudents, String schedule, Faculty instructor,
                  String lectureHall, boolean hasProjector, int numberOfSections) {
        super(courseId, title, description, creditHours, maxStudents, schedule, instructor);
        this.lectureHall = lectureHall;
        this.hasProjector = hasProjector;
        this.numberOfSections = numberOfSections;
    }

    // Getters and setters
    public String getLectureHall() {
        return lectureHall;
    }

    public void setLectureHall(String lectureHall) {
        this.lectureHall = lectureHall;
    }

    public boolean hasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    public int getNumberOfSections() {
        return numberOfSections;
    }

    public void setNumberOfSections(int numberOfSections) {
        this.numberOfSections = numberOfSections;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                ", lectureHall='" + lectureHall + '\'' +
                ", sections=" + numberOfSections +
                '}';
    }
}
