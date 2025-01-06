package com.codeWithSumit.FitnessTrackerService.services.workout;

import org.springframework.stereotype.Service;

import com.codeWithSumit.FitnessTrackerService.dto.WorkoutDto;
import com.codeWithSumit.FitnessTrackerService.entity.Workout;
import com.codeWithSumit.FitnessTrackerService.repository.WorkoutRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {


    private final WorkoutRepository workoutRepository;

    public WorkoutDto postWorkout(WorkoutDto workoutDto){
        Workout workout=new Workout();

        workout.setDate(workoutDto.getDate());
        workout.setType(workoutDto.getType());
        workout.setDuration(workoutDto.getDuration());
        workout.setCaloriesBurned(workoutDto.getCaloriesBurned());

        return workoutRepository.save(workout).getWorkoutDto();
    }
}
