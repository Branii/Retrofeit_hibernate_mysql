import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid")
    private Long id;
    
    private String firstname;
    private String lastname;
    private String email;
    private String mobile;

    public users() {}
    public users(String firstname, String lastname, String email, String mobile) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mobile = mobile;
    }

    //getters
    public Long getUid() {
        return this.id;
    }

    public String getFirstname(){
        return this.firstname;
    }

    public String getLastname(){
        return this.lastname;
    }

    public String getEmail(){
        return this.email;
    }

    public String getMobile(){
        return this.mobile;
    }

    //setters
    public void setUid(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    // @Override
    // public String toString()
    // {
    //     return "Vehicle [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname +", email=" + email +", mobile=" + mobile +"]";
    // }
    
}
