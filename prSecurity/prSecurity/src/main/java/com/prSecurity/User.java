package com.prSecurity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Setter
@Getter
//@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private @NotBlank String name;
    private @NotBlank String login;
    private @NotBlank String password;
    private @NotBlank boolean loggedIn;

    public User() {}

    public User(@NotBlank String username,
                @NotBlank String login,
                @NotBlank String password) {
        this.name = username;
        this.login = login;
        this.password = password;

    }
    public User(long id, String name, String login, String password){
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password,
                login);
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", password='" + password + '\'' +
                ", login=" + login +
                '}';
    }
}