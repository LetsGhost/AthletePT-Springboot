package com.athletept.athletept.trainingsplan.service;

import com.athletept.athletept.trainingsplan.dto.TrainingsPlanDto;
import com.athletept.athletept.trainingsplan.mapper.TrainingsplanMapper;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TrainingsPlanService {

    private TrainingsplanMapper

    public ResponseEntity<String> createTrainingsPlan(TrainingsPlanDto trainingsPlanDto) {



        return ResponseEntity.ok("Training plan created successfully");
    }
}
