package com.athletept.athletept.trainingsplan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SetDto {
    private String uuid;
    private int weight;
    private int reps;
    private String exerciseId;
    private Long warmupId;
}
