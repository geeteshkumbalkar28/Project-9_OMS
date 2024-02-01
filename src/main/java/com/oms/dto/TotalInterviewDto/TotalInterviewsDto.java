package com.oms.dto.TotalInterviewDto;

import com.oms.Entity.TotalInterviews;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalInterviewsDto {

    private int interviewId;

    private String date;
    private String status;
    private OffsetDateTime totalCallAttend;
    private String totalReplies;


    public TotalInterviewsDto(TotalInterviews totalInterviews) {
        this.date = totalInterviews.getDate();
        this.status = totalInterviews.getStatus();
        this.totalCallAttend = totalInterviews.getTotalCallAttend();
        this.totalReplies = totalInterviews.getTotalReplies();
        this.interviewId = totalInterviews.getInterviewId();


    }


}
