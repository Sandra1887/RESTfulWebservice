package ProjectWebServices.WebServices.dto;

import ProjectWebServices.WebServices.models.User;

/***
 * DataTransferObject-klass som används för att representera och strukturera login responses.
 */
public class LoginResponseDTO {
    private User user;
    private String jwt;

    public LoginResponseDTO() {}

    public LoginResponseDTO(User user, String jwt){
        this.user = user;
        this.jwt = jwt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
