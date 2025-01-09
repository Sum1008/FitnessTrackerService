package com.codeWithSumit.FitnessTrackerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWithSumit.FitnessTrackerService.entity.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Long> {

}
