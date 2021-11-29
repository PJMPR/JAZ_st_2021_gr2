package JAZ.lab06.demo.Services;

import JAZ.lab06.demo.Repositories.CalculationRepo;
import JAZ.lab06.demo.entities.CalculationParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    private final CalculationRepo calculationRepo;
    private final TimetableService timetableService;

    @Autowired
    public CalculationService(CalculationRepo calculationRepo, TimetableService timetableService) {
        this.calculationRepo = calculationRepo;
        this.timetableService = timetableService;
    }

    public long addNewCalculation(CalculationParameters calculationParameters) {
        calculationRepo.save(calculationParameters);
        timetableService.addNewTimetable(calculationParameters);
        return calculationParameters.getId();
    }

    public CalculationParameters getCalculation(long id) {
        return calculationRepo.findById(id);
    }
}
