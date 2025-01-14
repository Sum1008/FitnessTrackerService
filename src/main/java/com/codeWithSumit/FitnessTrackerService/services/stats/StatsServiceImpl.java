package com.codeWithSumit.FitnessTrackerService.services.stats;

import org.springframework.stereotype.Service;

import com.codeWithSumit.FitnessTrackerService.dto.StatsDto;
import com.codeWithSumit.FitnessTrackerService.repository.GoalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {


    private final GoalRepository goalRepository;

    public StatsDto getStats(){
        
        Long achievedGoals =goalRepository.countAchievedGoals();

        Long notAchievedGoals=goalRepository.countNotAchievedGoals();

        StatsDto dto= new StatsDto();

        dto.setAchievedGoals(achievedGoals !=null ? achievedGoals:0);
        dto.setNotAchievedGoals(notAchievedGoals != null ? notAchievedGoals :0);

        return dto ;


    }
}
