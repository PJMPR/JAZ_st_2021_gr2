package JAZ.lab06.demo.controllers;

import JAZ.lab06.demo.Repositories.TimetableRepo;
import JAZ.lab06.demo.Services.CalculationService;
import JAZ.lab06.demo.Services.TimetableService;
import JAZ.lab06.demo.entities.CalculationParameters;
import JAZ.lab06.demo.entities.Timetable;
import JAZ.lab06.demo.exporters.CSVExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping(path = "/credit")
public class MainController {
    private final TimetableRepo timetableRepo;
    private final CalculationService calculationService;
    private final TimetableService timetableService;

    @Autowired
    public MainController(TimetableRepo timetableRepo, CalculationService calculationService, TimetableService timetableService,CSVExporter csvExporter) {
        this.timetableRepo = timetableRepo;
        this.calculationService = calculationService;
        this.timetableService = timetableService;
    }

    @PostMapping(path = "/calculations")
    public long registerNewCalculation(@RequestBody CalculationParameters calculationParameters) {
        return calculationService.addNewCalculation(calculationParameters);
    }


    @GetMapping(path = "/timetable/{id}")
    public ResponseEntity getTimetableJSON(@PathVariable long id) {
        return ResponseEntity.ok().body(timetableService.getTimetable(id));
    }


    @GetMapping(path = "/timetable/{id}&")
    public ResponseEntity<Resource> getTimetableCSV(@PathVariable long id, @RequestParam String file) {
        List<Timetable> timetableList = timetableRepo.findAllById(id);
        if (file.equals("CSV")) {
            String filename = "file.csv";
            InputStreamResource inputStreamResource = new InputStreamResource(CSVExporter.toCSV(timetableList));
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                    .contentType(MediaType.parseMediaType("application/csv"))
                    .body(inputStreamResource);
        } else {
            return null;
        }
    }

}