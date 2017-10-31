package de.nordakademie.iaa.studentadmin.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 1L;
    private static final String adminUser = "admin";
    private static final String adminPassword ="admin"; // Normally this would be a salted and hashed in a DB.
    private String userName;
    private String password;
    private Map<String, Object> session;

    public String home() {
        return SUCCESS;
    }

    // Log Out user
    public String logOut() {
        session.remove("loginId");
        addActionMessage("You have been Successfully Logged Out");
        return SUCCESS;
    }

    // Login user
    public String login() {
        if (userName.isEmpty() || !userName.equals(adminUser) || password.isEmpty() || !password.equals(adminPassword)) {
            addActionError("Wrong username or password");
            return LOGIN;
        } else {
            session.put("loginId", userName);
            return SUCCESS;
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}