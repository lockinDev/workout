package com.lockinDev.workout.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.lockinDev.workout.entities.Workout;
import com.lockinDev.workout.repositories.WorkoutRepository;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @PreAuthorize("#workout.user == authentication.name")
    public void saveWorkout(Workout workout) {
        workoutRepository.save(workout);
    }

    public List<Workout> findWorkouts() {
        return workoutRepository.findAllByUser();
    }

    public void deleteWorkout(Integer id) {
        workoutRepository.deleteById(id);
    }
}
