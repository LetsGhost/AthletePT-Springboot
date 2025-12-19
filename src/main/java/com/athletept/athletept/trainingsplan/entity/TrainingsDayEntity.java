package com.athletept.athletept.trainingsplan.entity;

import com.athletept.athletept.commons.entity.BaseEntity;
import com.athletept.athletept.trainingsplan.enums.ImgEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "training_day")
public class TrainingsDayEntity extends BaseEntity {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private TrainingsPlanEntity plan;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ImgEnum img;

    private String name;
    private Boolean isSkipped;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "warmup_order")
    private List<WarmupEntity> warmups = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "exercise_order")
    private List<ExerciseEntity> exercises = new java.util.ArrayList<>();
}
