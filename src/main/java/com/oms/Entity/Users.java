package com.oms.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity

public class Users implements UserDetails {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column
    private LocalDate date;

    @Column(nullable = false, length = 250)
    private String email;

    @Column(length = 250)
    private String fullName;

    @Column(length = 45)
    private String gender;

    @Column(nullable = false, length = 45)
    private String moNumber;

    @Column(nullable = false, length = 250)
    private String password;

    @Column(length = 45)
    private String ref;

    @Column(length = 45)
    private String status;

    //    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
//    private Set<Roles> roles;
//
//
    @ManyToMany
    @JoinTable(name = "user_task", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "task_id"))
    private Set<Task> userTaskTasks;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Authority> set = new HashSet<>();
        this.userRoles.forEach(userRole -> {
            set.add(new Authority(userRole.getRole().getName()));
        });

        return set;
    }

    @Override
    public String getPassword() {

        return password;
    }

    @Override
    public String getUsername() {

        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }

//    public Integer getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(Integer user_id) {
//        this.user_id = user_id;
//    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMoNumber() {
        return moNumber;
    }

    public void setMoNumber(String moNumber) {
        this.moNumber = moNumber;
    }

//    public String getPassword() {
//        return password;
//    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Task> getUserTaskTasks() {
        return userTaskTasks;
    }

    public void setUserTaskTasks(Set<Task> userTaskTasks) {
        this.userTaskTasks = userTaskTasks;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Users(Integer user_id, LocalDate date, String email, String fullName, String gender, String moNumber, String password, String ref, String status, Set<Task> userTaskTasks, Set<UserRole> userRoles) {
        super();
        this.user_id = user_id;
        this.date = date;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.moNumber = moNumber;
        this.password = password;
        this.ref = ref;
        this.status = status;
        this.userTaskTasks = userTaskTasks;
        this.userRoles = userRoles;
    }

    public Users() {
        super();
        // TODO Auto-generated constructor stub
    }


}