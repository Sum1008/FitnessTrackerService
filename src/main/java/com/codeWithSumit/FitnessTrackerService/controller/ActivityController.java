package com.codeWithSumit.FitnessTrackerService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithSumit.FitnessTrackerService.dto.ActivityDto;
import com.codeWithSumit.FitnessTrackerService.services.activity.ActivityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping("/activity")
    public ResponseEntity<?> postActivity(@RequestBody ActivityDto dto) {
        ActivityDto createActivity = activityService.postActivity(dto);

        if (createActivity != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createActivity);

        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing went wrong");
        }

    }

    @GetMapping("/activities")
    public ResponseEntity<?> getActivities() {
        try {
            return ResponseEntity.ok(activityService.getActivities());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("some thing went wrong");

        }
    }

}
