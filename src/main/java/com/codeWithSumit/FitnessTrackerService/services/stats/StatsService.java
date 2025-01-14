package com.codeWithSumit.FitnessTrackerService.services.stats;

import com.codeWithSumit.FitnessTrackerService.dto.GraphDto;
import com.codeWithSumit.FitnessTrackerService.dto.StatsDto;

public interface StatsService {


    StatsDto getStats();

    GraphDto getGraphStats();
    
}
