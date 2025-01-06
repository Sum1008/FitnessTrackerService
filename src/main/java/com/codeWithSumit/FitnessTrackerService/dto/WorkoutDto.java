package com.codeWithSumit.FitnessTrackerService.dto;

import java.util.Date;

import lombok.Data;

@Data
public class WorkoutDto {


    private Long id;
    
    private String type;

    private Date date;

    private int duration;

    private int caloriesBurned;
}
