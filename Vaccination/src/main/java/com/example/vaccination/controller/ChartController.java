package com.example.vaccination.controller;

import com.example.vaccination.model.entity.Customer;
import com.example.vaccination.service.impl.CustomerServiceImpl;
import com.example.vaccination.service.impl.VaccineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ChartController {

    @Autowired
    private VaccineServiceImpl vaccineService;

    @Autowired
    private CustomerServiceImpl customerService;

    // Vaccine chart
    @GetMapping("/chartreportvaccine")
    public String getVaccineChartData(Model model,
                                @RequestParam(name = "yearSelection", required = false) String yearSelect) {
        List<String> vaccineList = vaccineService.count(yearSelect);
        model.addAttribute("yearSelection", yearSelect);
        model.addAttribute("vaccineList",vaccineList);

        return "reportvaccine-chart";
    }


    @GetMapping("/chart2")
    public String getChartData2(Model model,
                                @RequestParam(name = "yearSelection", required = false) String yearSelect) {
        List<String> vaccineList = vaccineService.count(yearSelect);
        model.addAttribute("yearSelection", yearSelect);
        model.addAttribute("vaccineList",vaccineList);

        return "chart2";
    }


    // Customers chart
    @GetMapping("/chartreportcustomer")
    public String getCustomerChartData(Model model,
                                      @RequestParam(name = "yearSelection", required = false) String yearSelect) {
        List<String>  customerList = customerService.chart(yearSelect);
        model.addAttribute("yearSelection", yearSelect);
        model.addAttribute("customerList",customerList);
        System.out.println(customerList);

        return "reportCustomer-chart";
    }



}