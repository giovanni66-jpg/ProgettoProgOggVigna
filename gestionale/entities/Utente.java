package gestionale.entities;

import org.json.simple.JSONObject;

public abstract class Utente {
    private String username;
    private String password;
    private String mail;
    
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
    
    public JSONObject toJsonObj() {
        JSONObject utenteJson = new JSONObject();
        utenteJson.put("Username", username);
        utenteJson.put("Mail", mail);
        utenteJson.put("Password", password);
        return utenteJson;
    }

    
}
