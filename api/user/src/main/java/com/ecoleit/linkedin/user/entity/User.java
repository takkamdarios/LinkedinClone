package com.ecoleit.linkedin.user.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Entity
@Table(name = "users", schema = "linkedin_user", catalog = "")
public class User implements UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "username", unique = true)
    private String username;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "email", unique = true)
    private String email;
    @Basic
    @Column(name = "birth_date")
    private Date birthDate;

    @Basic
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;
    @Basic
    @Column(name = "last_login_date")
    private Timestamp lastLoginDate;


    public User() {
    }

    public int getId() {
        return id;
    }

    //public void setId(int id) {
    //this.id = id;
    //}
    public String getUsername() {
        return username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(firstName, user.firstName)
                && Objects.equals(lastName, user.lastName) && Objects.equals(password, user.password)
                && Objects.equals(email, user.email) && Objects.equals(birthDate, user.birthDate)
                && Objects.equals(registrationDate, user.registrationDate)
                && Objects.equals(lastLoginDate, user.lastLoginDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, lastName, password, email, birthDate, registrationDate, lastLoginDate);
    }


}
