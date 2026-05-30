 package finalproject2;
 
public class SystemAdmin extends User {
    private String SecurityLevel;

    public SystemAdmin(){
        super();
    }

   
    public SystemAdmin(String SecurityLevel, String username, String password, String id, String name, String email, String contactInfo) {
        super(username, password, id, name, email, contactInfo);
        this.SecurityLevel = SecurityLevel;
      
    }
       public void SetSecurityLevel(String SecurityLevel){
        this.SecurityLevel = SecurityLevel;
    }
    public void CreateUser(User user){
        System.out.println("Created user: " + user.getName());
    }
    public void modifySystemSettings(){
        System.out.println("Modified System Settings.");
    }
    public void backupData(){
        System.out.println("Data backup Complete.");
    }
    public void managePermissions(User user){
        System.out.println("Manage permissions for user: " + user.getName());
    }

   
    public String getSecurityLevel() {
        return SecurityLevel;
    }

    public void setSecurityLevel(String SecurityLevel) {
        this.SecurityLevel = SecurityLevel;
    }
    
    
    @Override
    protected void displaySpecificDetails(){
        System.out.println("System Admin Details " );
        System.out.println("SecurityLevel: " + SecurityLevel);
    } 
}
