package com.example.demo.services;

import com.example.demo.charts.BarChart;
import com.example.demo.charts.IChartGenerator;
import com.example.demo.charts.LinearChart;
import com.example.demo.charts.PieChart;
import com.example.demo.model.Rental;
import com.example.demo.DTOStrategy.CustomerStatsDTO;
import com.example.demo.DTOStrategy.RentalStatsDTO;
import com.example.demo.repositories.RentalRepository;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class RentalService {
    public RentalRepository rentalRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public RentalService() {
    }

    public int getIncomeInMonth(int year, int month) {
        Timestamp timeFrom = Timestamp.valueOf(year + "-" + month + "-01 00:00:01");
        Timestamp timeTo = Timestamp.valueOf(year + "-" + month + "-31 23:59:59");
        return rentalRepository.findAll().stream()
                .map(Rental::getPaymentsByRentalId)
                .map(x -> x.stream().filter(p -> p.getPaymentDate().after(timeFrom) && p.getPaymentDate().before(timeTo)))
                .map(x -> x.map(p -> p.getAmount()).reduce(BigDecimal.ZERO, BigDecimal::add).intValue())
                .reduce(0, Integer::sum);
    }

    public List<RentalStatsDTO> getIncomeByMonth(int year) {
        ArrayList<RentalStatsDTO> rentalStatsDTO = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        IntStream.rangeClosed(1, 12).forEach(i -> temp.add(getIncomeInMonth(year, i)));
        IntStream.rangeClosed(1, 12).forEach(i -> rentalStatsDTO.add(new RentalStatsDTO(i, (temp.get(i - 1)))));
        return rentalStatsDTO;
    }

    public byte[] generateRentalLinearChart(String title, String xAxis, String yAxis, List<RentalStatsDTO> entryData) throws IOException {
        LinearChart linearChart = new LinearChart();
        DefaultCategoryDataset dataset = (DefaultCategoryDataset) linearChart.getDataset();

        entryData.forEach(rentalStats -> dataset.setValue(
                (Number) rentalStats.getRentValue(),
                "",
                rentalStats.getMonth()
        ));

        return linearChart.generate(title, "linear", xAxis, yAxis);
    }

    public byte[] generateRentalBarChart(String title, String xAxis, String yAxis, List<RentalStatsDTO> entryData) throws IOException {
        BarChart barChart = new BarChart();
        DefaultCategoryDataset dataset = (DefaultCategoryDataset) barChart.getDataset();

        entryData.forEach(stats -> dataset.setValue(
                (Number) stats.getRentValue(),
                "income",
                stats.getMonth()
        ));

        return barChart.generate(title, "bar", xAxis, yAxis);
    }

    public byte[] generateRentalPieChart(String title, List<RentalStatsDTO> entryData) throws IOException {
        IChartGenerator pieChart = new PieChart();
        DefaultPieDataset dataset = (DefaultPieDataset) pieChart.getDataset();

        entryData.forEach(stats -> dataset.setValue(
                stats.getMonth(),
                (Number) stats.getRentValue())
        );

        return pieChart.generate(title, "pie", "", "");
    }
}
