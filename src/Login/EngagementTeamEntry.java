import java.io.*;

class EngagementTeamEntry implements Serializable {
    private String username;
    private String password;

    public EngagementTeamEntry(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String newUsername) {
        username = newUsername;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public String toString() {
        return String.format("Username: %s, Password: %s", username, password);
    }
}
