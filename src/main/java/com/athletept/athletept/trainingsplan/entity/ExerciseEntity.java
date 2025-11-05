package com.athletept.athletept.trainingsplan.entity;

import com.athletept.athletept.commons.entity.BaseEntity;
import com.athletept.athletept.trainingsplan.enums.ExerciseType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "")
public class ExerciseEntity extends BaseEntity {

    private String name;
    private ExerciseType type;
    private Boolean isSkipped;
    private List<SetEntity> sets;
    private List<SetEntity> warmupSets;
}
