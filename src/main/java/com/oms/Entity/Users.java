package com.oms.Entity;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Users {

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Roles> roles;


    @ManyToMany
    @JoinTable(name = "user_task", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "task_id"))
    private Set<Task> userTaskTasks;

}