package com.codeWithSumit.FitnessTrackerService.services.stats;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import com.codeWithSumit.FitnessTrackerService.dto.GraphDto;
import com.codeWithSumit.FitnessTrackerService.dto.StatsDto;
import com.codeWithSumit.FitnessTrackerService.entity.Activity;
import com.codeWithSumit.FitnessTrackerService.entity.Workout;
import com.codeWithSumit.FitnessTrackerService.repository.ActivityRepository;
import com.codeWithSumit.FitnessTrackerService.repository.GoalRepository;
import com.codeWithSumit.FitnessTrackerService.repository.WorkoutRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {


    private final GoalRepository goalRepository;


    private final ActivityRepository activityRepository;

    private final WorkoutRepository workoutRepository;


    public StatsDto getStats(){

        Long achievedGoals =goalRepository.countAchievedGoals();

        Long notAchievedGoals=goalRepository.countNotAchievedGoals();

        Integer totalSteps =activityRepository.getTotalSteps();
        Double totalDistance =activityRepository.getTotalDistance();
        Integer totalActivityCaloriesBurned =activityRepository.getTotalActivityCalories();

        Integer totalWorkoutDuration = workoutRepository.getTotalDuration();
        Integer totalWorkoutCaloriesBurned = workoutRepository.getTotalCaloriesBurned();

        int totalCaloriesBurned=(totalActivityCaloriesBurned != null ? totalActivityCaloriesBurned : 0)+ (totalWorkoutCaloriesBurned!= null ? totalWorkoutCaloriesBurned:0);
        StatsDto dto= new StatsDto();

        dto.setAchievedGoals(achievedGoals !=null ? achievedGoals:0);
        dto.setNotAchievedGoals(notAchievedGoals != null ? notAchievedGoals :0);

        dto.setSteps(totalSteps != null ? totalSteps : 0);
        dto.setDistance(totalDistance != null ? totalDistance :0.0);
        dto.setTotalCaloriesBurned(totalCaloriesBurned);
        dto.setDuration(totalWorkoutDuration != null ? totalWorkoutDuration : 0); 
        return dto ;


    }

    public GraphDto getGraphStats() {
        Pageable pageable = PageRequest.of(0, 7);
    
        List<Workout> workouts = workoutRepository.findLast7Workouts(pageable);
        List<Activity> activities = activityRepository.findLast7Activities(pageable);
    
        GraphDto graphDTO = new GraphDto();
    
        graphDTO.setWorkout(workouts.stream().map(Workout::getWorkoutDto).collect(Collectors.toList()));
        graphDTO.setActivities(activities.stream().map(Activity::getActivityDTO).collect(Collectors.toList()));
    
        return graphDTO;
    }
}
