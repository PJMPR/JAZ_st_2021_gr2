package JAZ.lab06.demo.calculators;

import JAZ.lab06.demo.entities.CalculationParameters;
import JAZ.lab06.demo.entities.Timetable;
import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.List;

public class CreditCalculator {
    CalculationParameters calculationParameters;
    List<Timetable> timetableList = new ArrayList<>();
    double amount;
    int installmentCount;
    double percentage;
    double fixedRate;
    double capitalToPay;
    double capitalAlreadyPaid;
    double baseAmountToPay;
    double monthlyRate;


    public CreditCalculator(CalculationParameters calculationParameters) {
        this.calculationParameters = calculationParameters;
        this.amount = calculationParameters.getAmount();
        this.installmentCount = calculationParameters.getInstallmentCount();
        this.percentage = calculationParameters.getPercentage();
        this.fixedRate = calculationParameters.getFixedRate();
        this.baseAmountToPay = amount / installmentCount;
    }



    public List<Timetable> constantRateCalculation() {
        double x = Precision.round(1 + (percentage / 12), 5);
        monthlyRate = Precision.round((amount * Precision.round(Math.pow(x, installmentCount), 2) * (x - 1) / Precision.round((Math.pow(x, installmentCount) - 1), 2)), 2) + fixedRate;
        double interest = Precision.round((monthlyRate - baseAmountToPay - 30), 2);

        for (int i = 1; i <= installmentCount; i++) {
            capitalAlreadyPaid = baseAmountToPay * (i - 1);
            capitalToPay = amount - capitalAlreadyPaid;

            timetableList.add(i - 1, new Timetable(i, capitalAlreadyPaid, interest, fixedRate, capitalToPay, monthlyRate, calculationParameters));
        }

        return timetableList;
    }


    public List<Timetable> decreasingRateCalculation() {
        double monthlyRate;
        double interest;

        for (int i = 1; i <= installmentCount; i++) {
            capitalAlreadyPaid = baseAmountToPay * (i - 1);
            capitalToPay = amount - capitalAlreadyPaid;

            monthlyRate = Precision.round(((capitalToPay * percentage) / 12) + fixedRate, 2);
            interest = Precision.round((monthlyRate - 30), 2);

            timetableList.add(i - 1, new Timetable(i, capitalAlreadyPaid, interest, fixedRate, capitalToPay, monthlyRate, calculationParameters));
        }
        return timetableList;
    }


}
