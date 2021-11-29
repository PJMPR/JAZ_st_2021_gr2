package com.example.demo.services;

import com.example.demo.timetable.Calculation;
import com.example.demo.repositories.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    private final CalculationRepository calculationRepository;
    private final TimetableService timetableService;

    @Autowired
    public CalculationService(CalculationRepository calculationRepository, TimetableService timetableService) {
        this.calculationRepository = calculationRepository;
        this.timetableService = timetableService;
    }

    public long addNewCalculation(Calculation calculation) {
        calculationRepository.save(calculation);
        timetableService.addNewTimetable(calculation);
        return calculation.getId();
    }

    public Calculation getCalculation(long id) {
        return calculationRepository.findById(id);
    }
}
