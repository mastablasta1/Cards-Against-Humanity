package com.idziak.cards.model;

import com.idziak.cards.service.PasswordEncryptionService;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "\"User\"")
public class User implements Serializable {

    public static final String NICKNAME_COLUMN = "nickname";
    public static final String EMAIL_COLUMN = "email";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Email
    private String email;

    @Column(unique = true)
    @Size(min = 4, max = 32)
    private String nickname;

    @NotEmpty
    private String password;

    @Size(min = PasswordEncryptionService.SALT_LENGTH,
            max = PasswordEncryptionService.SALT_LENGTH)
    private String salt;

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
