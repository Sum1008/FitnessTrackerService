package com.codeWithSumit.FitnessTrackerService.services.goal;

import java.util.List;

import com.codeWithSumit.FitnessTrackerService.dto.GoalDto;

public interface GoalService {

    GoalDto postGoal(GoalDto dto);

    List<GoalDto> getGoals();

    GoalDto updateStatus(Long id);
}
