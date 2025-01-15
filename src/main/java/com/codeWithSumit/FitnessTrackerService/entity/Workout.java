package com.codeWithSumit.FitnessTrackerService.entity;

import java.util.Date;

import com.codeWithSumit.FitnessTrackerService.dto.WorkoutDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private Date date;

    private int duration;

    private int caloriesBurned;

    public WorkoutDto getWorkoutDto() {

        WorkoutDto workoutDto = new WorkoutDto();

        workoutDto.setId(id);
        workoutDto.setType(type);
        workoutDto.setDate(date);
        workoutDto.setDuration(duration);
        workoutDto.setCaloriesBurned(caloriesBurned);

        return workoutDto;

    }

}
