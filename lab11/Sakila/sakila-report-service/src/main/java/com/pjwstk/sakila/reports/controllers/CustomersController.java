package com.pjwstk.sakila.reports.controllers;

import com.pjwstk.sakila.reports.selftest.SakilaDbConnectionSelftest;
import com.pjwstk.sakila.reports.services.CustomersServices;
import com.pjwstk.sakila.reports.services.RequestedChartTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Locale;

@Controller
@RequiredArgsConstructor
@RequestMapping("customers")
public class CustomersController {

    private final CustomersServices customersServices;

    @GetMapping("mostSpent")
    public ResponseEntity getMostSpent(){
        return ResponseEntity.ok(customersServices.getCustomersWithMostSpentMoney());
    }

    @GetMapping("mostSpent.jpg")
    public ResponseEntity getMostSpentJpg(@RequestParam String chart){

            var chartType = RequestedChartTypes.valueOf(chart.toUpperCase(Locale.ROOT));
            InputStreamResource inputStreamResource
                    = new InputStreamResource(
                            new ByteArrayInputStream(customersServices.getChartForMostSpent(chartType)));
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(inputStreamResource);
    }

        @GetMapping("status")
        public ResponseEntity isAlive(){
            return ResponseEntity.ok("ALIVE");
        }


//    @GetMapping("selftest")
//    public ResponseEntity selfTest(){
//        return ResponseEntity.ok(List.of(
//                new SelfTestResult("CheckStorageForLogs","", true, null),
//                new SelfTestResult("CheckStorageForLogs","", true, null),
//                new SelfTestResult("CheckStorageForLogs","", true, null),
//                new SelfTestResult("CheckStorageForLogs","", true, null)
//                ));
//    }

//        @GetMapping("selftest")
//        public ResponseEntity selfTest(SakilaDbConnectionSelftest diskTest){
//            return ResponseEntity.ok(List.of(
////                new SelfTestResult("CheckStorageForLogs","Checking that there is more than 5% free storage", diskTest.passed(), null)
//                    diskTest.execute()
//
//            ));
//        }

    }

