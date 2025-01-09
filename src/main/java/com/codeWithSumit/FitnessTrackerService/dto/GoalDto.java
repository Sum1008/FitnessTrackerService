package com.codeWithSumit.FitnessTrackerService.dto;

import java.util.Date;

import lombok.Data;

@Data
public class GoalDto {

     private Long id ;
    
    private String description;

    private Date startDate;

    private Date endDate;

    private boolean achieved;

}
