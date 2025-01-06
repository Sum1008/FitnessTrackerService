package com.codeWithSumit.FitnessTrackerService.services.activity;

import java.util.List;

import com.codeWithSumit.FitnessTrackerService.dto.ActivityDto;

public interface ActivityService {

    ActivityDto postActivity(ActivityDto dto);

    List<ActivityDto> getActivities();
    
    
}
