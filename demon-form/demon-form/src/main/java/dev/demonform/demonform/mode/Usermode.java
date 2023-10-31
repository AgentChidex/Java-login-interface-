package dev.demonform.demonform.mode;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users_table")

public class Usermode {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
String login;
String password;
String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usermode usermode = (Usermode) o;
        return Objects.equals(id, usermode.id) && Objects.equals(login, usermode.login) && Objects.equals(password, usermode.password) && Objects.equals(email, usermode.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email);
    }

    @Override
    public String toString() {
        return "Usermode{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


