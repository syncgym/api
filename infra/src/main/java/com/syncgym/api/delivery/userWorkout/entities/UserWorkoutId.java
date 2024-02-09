package com.syncgym.api.delivery.userWorkout.entities;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class UserWorkoutId {


    private Long workoutId;

    private Long userId;

    public UserWorkoutId(Long workoutId, Long userId) {
        this.workoutId = workoutId;
        this.userId = userId;
    }

    public UserWorkoutId() {
    }

    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWorkoutId that = (UserWorkoutId) o;
        return Objects.equals(workoutId, that.workoutId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutId, userId);
    }
}
