package e.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity(name = "account")
public class Account {
    @Column(name = "login")
    @Id
    private String login;

    public Account(String login) {
        this.login = login;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return String.format("Account{login:%s}", this.login);
    }
}
