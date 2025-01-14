package com.codeWithSumit.FitnessTrackerService.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.codeWithSumit.FitnessTrackerService.entity.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Long> {


    @Query("SELECT SUM(w.duration) FROM Workout w")
    Integer getTotalDuration();

    @Query("SELECT SUM(w.caloriesBurned) FROM Workout w")
    Integer getTotalCaloriesBurned();

    @Query("SELECT w FROM Workout w ORDER BY w.date DESC")  // Adjust 'date' to your actual date column
    List<Workout> findLast7Workouts(Pageable pageable);
    
   
}
