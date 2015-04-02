package com.idziak.cards.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "\"User\"")
@NamedQueries({
        @NamedQuery(name = User.FIND_BY_NICKNAME, query = "SELECT u FROM User u WHERE u.nickname = :nickname"),
        @NamedQuery(name = User.FIND_BY_EMAIL, query = "SELECT u FROM User u WHERE u.email = :email")
})
public class User implements Serializable {

    public static final String FIND_BY_NICKNAME = "User.findByNickname";
    public static final String FIND_BY_EMAIL = "User.findByEmail";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    @Column(unique = true)
    @Size(min = 4, max = 32)
    private String nickname;

    @Size(min = 6, max = 32)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
