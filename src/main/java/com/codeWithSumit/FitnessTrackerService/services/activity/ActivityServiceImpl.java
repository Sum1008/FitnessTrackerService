package com.codeWithSumit.FitnessTrackerService.services.activity;

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
}
