package com.codeWithSumit.FitnessTrackerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWithSumit.FitnessTrackerService.entity.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Long> {

}
