package JAZ.lab06.demo.Services;

import JAZ.lab06.demo.Repositories.TimetableRepo;
import JAZ.lab06.demo.calculators.CreditCalculator;
import JAZ.lab06.demo.entities.CalculationParameters;
import JAZ.lab06.demo.entities.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {
    private final TimetableRepo timetableRepo;

    @Autowired
    public TimetableService(TimetableRepo timetableRepo) {
        this.timetableRepo = timetableRepo;
    }

    public void addNewTimetable(CalculationParameters calculationParameters) {
        switch (calculationParameters.getInstallmentType()) {
            case CONSTANT -> timetableRepo.saveAll(new CreditCalculator(calculationParameters).constantRateCalculation());
            case DECREASING -> timetableRepo.saveAll(new CreditCalculator(calculationParameters).decreasingRateCalculation());
        }
    }

    public List<Timetable> getTimetable(long id) {
        return timetableRepo.findAllById(id);
    }
}

