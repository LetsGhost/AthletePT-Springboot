package com.athletept.athletept.trainingsplan.entity;

import com.athletept.athletept.commons.entity.BaseEntity;
import com.athletept.athletept.trainingsplan.enums.ImgEnum;
import com.athletept.athletept.trainingsplan.enums.TrainingsPlanType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "trainings_plan")
public class TrainingsPlanEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TrainingsPlanType type;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "day_index")
    private List<TrainingsDayEntity> trainingDays;
}
