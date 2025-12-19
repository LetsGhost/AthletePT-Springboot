package com.athletept.athletept.trainingsplan.entity;

import com.athletept.athletept.commons.entity.BaseEntity;
import com.athletept.athletept.trainingsplan.enums.ExerciseType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "exercise")
public class ExerciseEntity extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private ExerciseType type;

    private Boolean isSkipped;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "day_id")
    private TrainingsDayEntity day;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "set_order")
    private List<SetEntity> sets = new ArrayList<>();
}
