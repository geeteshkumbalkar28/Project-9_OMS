package com.oms.Entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Project {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;

    @Column
    private String assignedTo;

    @Column
    private String clientName;

    @Column(name = "\"description\"")
    private String description;

    @Column(nullable = false)
    private Integer duration;

    @Column
    private OffsetDateTime endDate;

    @Column
    private String projectAssignment;

    @Column
    private String projectBugs;

    @Column
    private String projectName;

    @Column
    private OffsetDateTime startDate;

    @Column
    private String status;

    @OneToMany(mappedBy = "project")
    private Set<Token> taskTokens;

}