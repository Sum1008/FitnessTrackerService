package com.codeWithSumit.FitnessTrackerService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.Date; // Importing correct type for date

import com.codeWithSumit.FitnessTrackerService.dto.ActivityDto;

@Entity
@Data
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;  // Corrected type for date

    private int steps;

    private double distance;

    private int caloriesBurned;

    public ActivityDto getActivityDTO(){
        ActivityDto activityDto =new ActivityDto();

        activityDto.setId(id);
        activityDto.setDate(date);
        activityDto.setDistance(distance);
        activityDto.setSteps(steps);
        activityDto.setCaloriesBurned(caloriesBurned);

        return activityDto;
        
    
    }
}
