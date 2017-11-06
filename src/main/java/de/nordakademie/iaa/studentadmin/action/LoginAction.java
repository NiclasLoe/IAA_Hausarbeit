package de.nordakademie.iaa.studentadmin.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Class that contains all methods concerning login/logout.
 *
 * @author Lennart Meincke
 */
public class LoginAction extends ActionSupport implements SessionAware {

    /**
     * The serial version.
     */
    private static final long serialVersionUID = 1L;
    /**
     * The admin username.
     */
    private static final String adminUser = "admin";
    /**
     * The admin password.
     */
    private static final String adminPassword = "admin"; // Normally this would be a salted and hashed in a DB.
    /**
     * The username that was typed in..
     */
    private String userName;
    /**
     * The password that was typed in.
     */
    private String password;
    /**
     * The session map.
     */
    private Map<String, Object> session;

    public String home() {
        return SUCCESS;
    }

    /**
     * Logout method.
     *
     * @return Struts outcome.
     */
    public String logOut() {
        session.remove("loginId");
        addActionMessage(getText("success.logOut"));
        return SUCCESS;
    }

    /**
     * Login method.
     *
     * @return Struts outcome.
     */
    public String login() {
        if (userName.isEmpty() || !userName.equals(adminUser)
                || password.isEmpty() || !password.equals(adminPassword)) {
            addActionError(getText("error.userNameOrPassword"));
            return LOGIN;
        } else {
            session.put("loginId", userName);
            return SUCCESS;
        }
    }

    // Getter and setter

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