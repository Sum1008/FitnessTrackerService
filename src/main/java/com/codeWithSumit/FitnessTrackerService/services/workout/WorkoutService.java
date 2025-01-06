package com.codeWithSumit.FitnessTrackerService.services.workout;

import com.codeWithSumit.FitnessTrackerService.dto.WorkoutDto;

public interface WorkoutService {

    WorkoutDto postWorkout(WorkoutDto workoutDto);

}
