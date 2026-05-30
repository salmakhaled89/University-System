 package finalproject2;
 
 
import java.util.Scanner;
public abstract class User {
    private String username;
    private String password;
    private String id;
    private String name;
    private String email;
    private String contactInfo;
 
    
    public User() {
    }

    public User(String username,  String password, String id, String name, String email, String contactInfo) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactInfo = contactInfo;
    }

 
    

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword( String password) {
        if(password.length()<6){
            System.out.println("password must be at least 6 characters");
        }
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContactInfo() {
        return contactInfo;
    }
    
    
    public boolean login(String username,String password){
        if(username.equals(getUsername())&&password.equals(getPassword()) ){
            return true;
        }else{
            System.out.println("invalid username or password");
            return false;
        }
    }
    
        public void displayProfile(){
        System.out.println(" PROFILE ");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
   
        }

public void updateProfile(Scanner input){
    System.out.print("New name: ");
    String newName=input.next();
    setName(newName);
    System.out.print("New id:");
    String newId=input.next();
    setId(newId);
    System.out.print("New contact information: ");
    String newContactInfo=input.next();
    setContactInfo( newContactInfo);
}
public void resetPassword(String newPassword,String oldPassword){
    if(this.password.equals(oldPassword)){
        if(newPassword.length()>=6){
            setPassword(newPassword);
        }else{
            System.out.println("password must be at least 6 characters");
        }
    }else{
        System.out.println("invalid password");
    }
}
    public void logout(){
        System.out.println("logged out");
    }
    protected abstract void displaySpecificDetails();
    public void generateReport(String report){
        System.out.println(report);
}
    public double calculatePayroll(){
        return 8000;
    }

 @Override
public String toString() {
    return "Faculty[ID=" + getId() + ", Name=" + getName() + ", Email=" + getEmail() + "]";
}
    
}
