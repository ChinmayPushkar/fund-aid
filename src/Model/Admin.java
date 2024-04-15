
package Model;

public class Admin {
    
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    
    public Admin(String email,String password){
        this.email = email;
        this.password = password;
    }
    
}
