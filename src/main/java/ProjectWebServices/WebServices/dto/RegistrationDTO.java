package ProjectWebServices.WebServices.dto;

/***
 * DataTransferObject-klass som används för att hålla information om registrering och att förflytta denna
 * informationen
 */
public class RegistrationDTO {
    private String username;
    private String password;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Registration info -> Username: " + this.username + ". Password: " + this.password;
    }
}
