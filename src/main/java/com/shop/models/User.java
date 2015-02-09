package com.shop.models;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * Created by Krzysztof Januś on 2015-02-04.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column(name = "username", nullable = false, unique = true)
    @NotEmpty(message = "E-mail is required")
    @Email
    private String username;

    @Column(name = "password", nullable = false)
    @Length(min = 3, message = "Password must have a minimum of 3 characters")
    private String password;

    @Transient
    @Length(min = 3, message = "Password must have a minimum of 3 characters")
    private String confirmPassword;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @ManyToOne(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Valid
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private Person person;

    public User() { }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Role getRole() {
        return role;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", enabled=" + enabled +
                ", role=" + role +
                ", person=" + person +
                '}';
    }
}
