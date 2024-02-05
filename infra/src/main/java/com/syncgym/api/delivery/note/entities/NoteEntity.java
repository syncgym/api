package com.syncgym.api.delivery.note.entities;

import com.syncgym.api.delivery.commonUser.entities.CommonUserEntity;
import com.syncgym.api.delivery.exercise.entities.ExerciseEntity;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "notes")
public class NoteEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private CommonUserEntity commonUser;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "exercise_id")
    private ExerciseEntity exercise;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date date;

    public NoteEntity(Long id, CommonUserEntity commonUser, ExerciseEntity exercise, String description, Date date) {
        this.id = id;
        this.commonUser = commonUser;
        this.exercise = exercise;
        this.description = description;
        this.date = date;
    }

    public NoteEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommonUserEntity getCommonUser() {
        return commonUser;
    }

    public void setCommonUser(CommonUserEntity commonUser) {
        this.commonUser = commonUser;
    }

    public ExerciseEntity getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseEntity exercise) {
        this.exercise = exercise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteEntity that = (NoteEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(commonUser, that.commonUser) && Objects.equals(exercise, that.exercise) && Objects.equals(description, that.description) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commonUser, exercise, description, date);
    }
}
