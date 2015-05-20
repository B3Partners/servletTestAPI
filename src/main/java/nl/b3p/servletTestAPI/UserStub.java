package nl.b3p.servletTestAPI;

import java.util.HashSet;

/**
 *
 * @author rachelle
 */
public class UserStub {
    private int userid;
    private String firstName;
    private String surname;
    private String username;
    private String password;
    private String email;
    private HashSet<String> roles;
    
    public UserStub(){
        this("","","","","");
    }
    
    public UserStub(String username,String password,String email){
        this(username,password,email,"","");
    }
    
    public UserStub(String username,String password,String email,String firstName,String surname){
        this.firstName  = firstName;
        this.surname    = surname;
        this.username   = username;
        this.password   = password;
        this.email      = email;
        this.userid     = -1;
        this.roles      = new HashSet<String>();
    }
    
    public void setId(int userid){
        this.userid = userid;
    }
    
    public int getId(){
        return this.userid;
    }
    
    public void setFirstName(String firstName){
        this.firstName  = firstName;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public void setSurname(String surname){
        this.surname    = surname;
    }
    
    public String getSurname(){
        return this.surname;
    }
    
    public void setEmailAddress(String emailAddress){
        this.email  = emailAddress;
    }
    
    public String getEmailAddress(){
        return this.email;
    }
    
    public void setUsername(String username){
        this.username   = username;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setPassword(String password){
        this.password   = password;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setRole(String role){
        if( !this.roles.contains(role) )    this.roles.add(role);
    }

    public boolean checkRole(String role) {
        return this.roles.contains(role);
    }
}
