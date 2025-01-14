package com.codeWithSumit.FitnessTrackerService.dto;

import java.util.List;

import lombok.Data;

@Data
public class GraphDto {

    private List<WorkoutDto> workout;
    
    private List<ActivityDto> activities;

    
}
