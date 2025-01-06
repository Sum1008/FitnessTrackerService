package com.codeWithSumit.FitnessTrackerService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithSumit.FitnessTrackerService.dto.WorkoutDto;
import com.codeWithSumit.FitnessTrackerService.services.workout.WorkoutService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class WorkoutController {


    public final WorkoutService workoutService;


    @PostMapping("/workout")
    public ResponseEntity<?> postWorkout(@RequestBody WorkoutDto workoutDto){
        try{
            return ResponseEntity.ok(workoutService.postWorkout(workoutDto));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("some thing went wrong");
        }
    }
}
