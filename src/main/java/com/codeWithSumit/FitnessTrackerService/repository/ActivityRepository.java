package com.codeWithSumit.FitnessTrackerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWithSumit.FitnessTrackerService.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {

}
