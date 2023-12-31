package ProjectWebServices.WebServices.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

/***
 * Entityklass för "Role" med dess attribut och annotations.
 * "@Table" vad tabellen heter
 * "@Id" som sätter id:t som primary key
 * "@GeneratedValue" specificerar hur primary key skall genereras och "AUTO" låter JPA avgöra vilken som är bästa
 * strategin att använda.
 * "@Column(name" - vad kolumnen för primary key skall heta
 *
 */
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;
    private String authority;

    public Role(){}
    public Role(String authority) {
        this.authority = authority;
    }

    public Role(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
