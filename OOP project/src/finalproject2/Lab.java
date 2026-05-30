 package finalproject2;
 

public class Lab extends Course {
    private String labRoom;
    private boolean requiresLabCoat;
    private int labCapacity;
    private String equipmentList;

    public Lab() {
        super();
    }

    public Lab(String courseId, String title, String description, int creditHours,
               int maxStudents, String schedule, Faculty instructor,
               String labRoom, boolean requiresLabCoat, int labCapacity, String equipmentList) {
        super(courseId, title, description, creditHours, maxStudents, schedule, instructor);
        this.labRoom = labRoom;
        this.requiresLabCoat = requiresLabCoat;
        this.labCapacity = labCapacity;
        this.equipmentList = equipmentList;
    }

    // Getters and setters
    public String getLabRoom() {
        return labRoom;
    }

    public void setLabRoom(String labRoom) {
        this.labRoom = labRoom;
    }

    public boolean requiresLabCoat() {
        return requiresLabCoat;
    }

    public void setRequiresLabCoat(boolean requiresLabCoat) {
        this.requiresLabCoat = requiresLabCoat;
    }

    public int getLabCapacity() {
        return labCapacity;
    }

    public void setLabCapacity(int labCapacity) {
        this.labCapacity = labCapacity;
    }

    public String getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(String equipmentList) {
        this.equipmentList = equipmentList;
    }

    @Override
    public String toString() {
        return "courseId='" +
                ", title='" +
                ", labRoom='" + labRoom + '\'' +
                ", capacity=" + labCapacity +
                '}';
    }
}
