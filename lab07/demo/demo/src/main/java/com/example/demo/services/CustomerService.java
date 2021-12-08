package com.example.demo.services;

import com.example.demo.DTOStrategy.CustomerStatsDTO;
import com.example.demo.DTOStrategy.PaymentDTO;
import com.example.demo.DTOStrategy.RentalStatsDTO;
import com.example.demo.charts.BarChart;
import com.example.demo.charts.IChartGenerator;
import com.example.demo.charts.PieChart;
import com.example.demo.repositories.CustomerRepository;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Component
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    private final List<CustomerStatsDTO> customerDTOList = new ArrayList<>();


    @Autowired
    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void setCustomerSpent(CustomerStatsDTO customerStatsDTO) {
        customerStatsDTO.setSpent(customerStatsDTO.getPayments()
                .stream().map(PaymentDTO::getAmount)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add));
    }

    public void setCustomerWatched(CustomerStatsDTO customerStatsDTO) {
        customerStatsDTO.setWatched(customerStatsDTO.getPayments().size());
    }

    public List<CustomerStatsDTO> setCustomers() {
        if (customerDTOList.isEmpty()) {
            for (int i = 1; i < customerRepository.count(); i++) {
                CustomerStatsDTO customerStatsDTO = mapper.map(customerRepository.getById(i), CustomerStatsDTO.class);
                setCustomerSpent(customerStatsDTO);
                setCustomerWatched(customerStatsDTO);
                customerDTOList.add(customerStatsDTO);
            }
        }
        return customerDTOList;
    }

    public List<CustomerStatsDTO> rankCustomersByMoneySpent() {
        return setCustomers().stream()
                .sorted(Comparator.comparing(CustomerStatsDTO::getSpent).reversed())
                .limit(10).collect(Collectors.toList());
    }

    public List<CustomerStatsDTO> rankCustomersByMovieWatched() {
        return setCustomers().stream()
                .sorted(Comparator.comparing(CustomerStatsDTO::getWatched).reversed())
                .limit(10).collect(Collectors.toList());
    }


    public byte[] generateCustomerPieChart(String title, String field, List<CustomerStatsDTO> entryData) throws IOException {
        IChartGenerator pieChart = new PieChart();
        DefaultPieDataset dataset = (DefaultPieDataset) pieChart.getDataset();

        switch (field) {
            case "movies":
                entryData.forEach(customerStats -> dataset.setValue(
                        customerStats.getCustomerId(),
                        (Number) customerStats.getWatched()));
                break;
            case "money":
                entryData.forEach(customerStats -> dataset.setValue(customerStats.getCustomerId(),
                        customerStats.getSpent()));
                break;
        }

        return pieChart.generate(title, "pie", "", "");
    }


    public byte[] generateCustomerBarChart(String title, String field, String xAxis, String yAxis, List<CustomerStatsDTO> entryData) throws IOException {
        BarChart barChart = new BarChart();
        DefaultCategoryDataset dataset = (DefaultCategoryDataset) barChart.getDataset();
        switch (field) {
            case "movies":

                entryData.forEach(customerStats -> dataset.setValue(
                        (Number) customerStats.getWatched(),
                        customerStats.getCustomerId(),
                        "Customers"));
                break;
            case "money":
                entryData.forEach(customerStats -> dataset.setValue(
                        customerStats.getSpent(),
                        customerStats.getCustomerId(),
                        "Customers"));
                break;
        }
        return barChart.generate(title, "bar", xAxis, yAxis);
    }

    public byte[] generateRentalBarChart(String title, String xAxis, String yAxis, List<RentalStatsDTO> entryData) throws IOException {
        BarChart barChart = new BarChart();
        DefaultCategoryDataset dataset = (DefaultCategoryDataset) barChart.getDataset();

        entryData.forEach(stats -> dataset.setValue(
                (Number) stats.getRentValue(),
                "rentals",
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

    public List<RentalStatsDTO> rentMoviesByMonths(int year) {
        List<RentalStatsDTO> rentalStats = new ArrayList<>();
        List<Integer> sumOfRentals = new ArrayList<>();

        IntStream.rangeClosed(1, 12).forEach(i -> sumOfRentals.add(customerRepository.findAll().stream().map(x -> x.getRentalsByMonth(year, i)).reduce(0, Integer::sum)));
        IntStream.rangeClosed(1, 12).forEach(i -> rentalStats.add(new RentalStatsDTO(i, sumOfRentals.get(i - 1))));

        return rentalStats;
    }

    public Object getMoviesForCustomer(int year, int id) {
        ArrayList<RentalStatsDTO> monthStats = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        IntStream.rangeClosed(1, 12).forEach(i -> temp.add(customerRepository.findById(id).stream().map(x -> x.getRentalsByMonth(year, i)).reduce(0, Integer::sum)));
        IntStream.rangeClosed(1, 12).forEach(i -> monthStats.add(new RentalStatsDTO(i, temp.get(i - 1))));
        return monthStats;


    }
}