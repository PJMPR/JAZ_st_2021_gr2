package com.prSecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.prSecurity.service.DateService;

@Controller
public class DateController {
    @Autowired
    private DateService dateService;

    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping("/date")
    public String data(Model model) {
        model.addAttribute("date", dateService.getDate());
        return "date";
    }
}
