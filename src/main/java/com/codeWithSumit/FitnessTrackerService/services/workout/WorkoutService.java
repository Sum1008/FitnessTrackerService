package com.codeWithSumit.FitnessTrackerService.services.workout;

import java.util.List;

import com.codeWithSumit.FitnessTrackerService.dto.WorkoutDto;

public interface WorkoutService {

    WorkoutDto postWorkout(WorkoutDto workoutDto);

    List<WorkoutDto> getWorkot();

}
