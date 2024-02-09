package com.syncgym.api.delivery.userWorkout.entities;

import com.syncgym.api.delivery.commonUser.entities.CommonUserEntity;
import com.syncgym.api.delivery.workout.entities.WorkoutEntity;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_workout")
public class UserWorkoutEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UserWorkoutId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private CommonUserEntity commonUser;

    @ManyToOne
    @MapsId("workoutId")
    @JoinColumn(name = "workout_id", referencedColumnName = "id")
    private WorkoutEntity workout;

    @Column(name = "completed_splits", nullable = false)
    private Byte completedSplits;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    public UserWorkoutEntity(UserWorkoutId id, CommonUserEntity commonUser, WorkoutEntity workout, Byte completedSplits, Boolean isActive) {
        this.id = id;
        this.commonUser = commonUser;
        this.workout = workout;
        this.completedSplits = completedSplits;
        this.isActive = isActive;
    }

    public UserWorkoutEntity() {
    }

    public UserWorkoutId getId() {
        return id;
    }

    public void setId(UserWorkoutId id) {
        this.id = id;
    }

    public CommonUserEntity getCommonUser() {
        return commonUser;
    }

    public void setCommonUser(CommonUserEntity commonUser) {
        this.commonUser = commonUser;
    }

    public WorkoutEntity getWorkout() {
        return workout;
    }

    public void setWorkout(WorkoutEntity workout) {
        this.workout = workout;
    }

    public Byte getCompletedSplits() {
        return completedSplits;
    }

    public void setCompletedSplits(Byte completedSplits) {
        this.completedSplits = completedSplits;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWorkoutEntity that = (UserWorkoutEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(commonUser, that.commonUser) && Objects.equals(workout, that.workout) && Objects.equals(completedSplits, that.completedSplits) && Objects.equals(isActive, that.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commonUser, workout, completedSplits, isActive);
    }
}
