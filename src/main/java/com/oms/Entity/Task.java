package com.oms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.OffsetDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Task {

    @Id
    @Column(name ="task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer task_id;

    @Column
    private String assignedDate;

    @Column
    private String assignedEndDate;

    @Column
    private String assignedTo;

    @Column
    private String calls;

    @Column
    private String comments;

    @Column
    private String completedTask;

    @Column(name = "description")
    private String description;

    @Column(nullable = false)
    private Boolean done;

    @Column
    private OffsetDateTime dueDate;

    @Column(nullable = false)
    private Boolean inProgress;

    @Column
    private String message;

    @Column
    private String noOfTask;

    @Column
    private String pendingTask;

    @Column
    private String projectName;

    @Column(nullable = false)
    private Boolean status;

    @Column
    private String task;

    @Column
    private String taskName;

    @Column
    private String taskSubmitted;

    @Column
    private String totalCall;

    @Column
    private OffsetDateTime totalCallAttended;

    @Column
    private String totalPeopleConsulted;

    @Column
    private String totalReplies;

    @OneToMany(mappedBy = "task")
    private Set<Token> taskTokens;

}