package com.codeWithSumit.FitnessTrackerService.dto;

import lombok.Data;
import java.util.Date; // Corrected import

@Data
public class ActivityDto {

    private Long id;

    private Date date; // Corrected type for date

    private int steps;

    private double distance;

    private int caloriesBurned;
}
