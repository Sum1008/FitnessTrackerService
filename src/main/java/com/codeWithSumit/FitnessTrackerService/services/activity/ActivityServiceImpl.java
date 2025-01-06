package com.codeWithSumit.FitnessTrackerService.services.activity;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.codeWithSumit.FitnessTrackerService.dto.ActivityDto;
import com.codeWithSumit.FitnessTrackerService.entity.Activity;
import com.codeWithSumit.FitnessTrackerService.repository.ActivityRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityDto postActivity(ActivityDto dto){

        Activity activity = new Activity();

        activity.setDate(dto.getDate());
        activity.setSteps(dto.getSteps());
        activity.setDistance(dto.getDistance());
        activity.setCaloriesBurned(dto.getCaloriesBurned());

        return activityRepository.save(activity).getActivityDTO();

    }

    public List<ActivityDto> getActivities(){
         List<Activity> activities=activityRepository.findAll();
         return activities.stream().map(Activity::getActivityDTO).collect(Collectors.toList());

    }
    

}
