package com.oms.Entity;

import com.oms.dto.TotalInterviewDto.TotalInterviewsDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class TotalInterviews {

    @Id
    @Column(name = "totalInterview_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer interviewId;

    @Column
    private String date;

    @Column
    private String status;

    @Column
    private OffsetDateTime totalCallAttend;

    @Column
    private String totalReplies;

    public TotalInterviews(TotalInterviewsDto totalInterviews) {
        this.interviewId = totalInterviews.getInterviewId();
        this.date = totalInterviews.getDate();
        this.status = totalInterviews.getStatus();
        this.totalCallAttend = totalInterviews.getTotalCallAttend();
        this.totalReplies = totalInterviews.getTotalReplies();
    }
}