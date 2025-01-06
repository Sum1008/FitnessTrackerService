package com.codeWithSumit.FitnessTrackerService.services.workout;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public List<WorkoutDto> getWorkot(){
        List<Workout> workouts=workoutRepository.findAll();

        return workouts.stream().map(Workout::getWorkoutDto).collect(Collectors.toList());
    }
}
