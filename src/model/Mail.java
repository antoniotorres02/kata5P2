package model;

public class Mail {
    String mail;
    
    public Mail(String mail) {
        this.mail = mail;
    }
    
    public String getDomain() {
        return this.mail.substring(this.mail.indexOf("@") + 1);
    }
    
    public String mail() {
        return this.mail;
    } 
}
