package gestionale.entities;

public class Admin {
    
    private String username = "Admin";
    private String password = "Admin1234";
    private String mail = "pieromarraffa1999@gmail.com";

    public Admin(){
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
