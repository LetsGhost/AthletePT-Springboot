package com.athletept.athletept.trainingsplan.entity;

import com.athletept.athletept.commons.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "exercise_set")
public class SetEntity extends BaseEntity {

    private int weight;
    private int reps;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "exercise_id")
    private ExerciseEntity exercise;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "warmup_id")
    private WarmupEntity warmup;
}
