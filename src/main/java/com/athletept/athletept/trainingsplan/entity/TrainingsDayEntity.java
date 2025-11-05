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
@Table(name = "")
public class TrainingsDayEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ImgEnum img;

    private String name;
    private Boolean isSkipped;
    private List<ExerciseEntity> exercises;
    private List<WarmupEntity> warmups;
}
