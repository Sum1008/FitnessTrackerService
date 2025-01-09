package com.codeWithSumit.FitnessTrackerService.services.goal;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.codeWithSumit.FitnessTrackerService.dto.GoalDto;
import com.codeWithSumit.FitnessTrackerService.entity.Goal;
import com.codeWithSumit.FitnessTrackerService.repository.GoalRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService{

    private final GoalRepository goalRepository;

    public GoalDto postGoal(GoalDto dto){
        Goal goal = new Goal();

        goal.setDescription(dto.getDescription());
        goal.setStartDate(dto.getStartDate());
        goal.setEndDate(dto.getEndDate());
        goal.setAchieved(false);

        return goalRepository.save(goal).getGoalDTO();

    }

    public List<GoalDto> getGoals(){
        List<Goal> goals = goalRepository.findAll();
         return goals.stream().map(Goal::getGoalDTO).collect(Collectors.toList());
    }

    public GoalDto updateStatus(Long id){
        Optional<Goal> optionalGoal =goalRepository.findById(id);

        if(optionalGoal.isPresent()){
            Goal existingGoal =optionalGoal.get();
            existingGoal.setAchieved(true);
            return goalRepository.save(existingGoal).getGoalDTO();
        }

        throw new EntityNotFoundException("Goal not found");
        
    }
}
