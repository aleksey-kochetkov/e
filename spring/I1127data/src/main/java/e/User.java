package e;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "uzer")
public class User {
    @Id
    private String login;
    private String name;

    public User() {
    }

    public User(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = this.login.hashCode();
        return result * 31 + this.name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User u = (User) o;
        if (!(this.login == null ? u.login == null
                                         : this.login.equals(u.login))) {
            return false;
        }
        if (!(this.name == null ? u.name == null
                                           : this.name.equals(u.name))) {
            return false;
        }
        return true;
    }
}
