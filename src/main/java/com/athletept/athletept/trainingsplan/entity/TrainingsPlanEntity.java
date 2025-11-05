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
@Table(name = "TrainingsPlans")
public class TrainingsPlanEntity extends BaseEntity {

    private Type type;
    private List<TrainingsDayEntity> trainingDays;
}
