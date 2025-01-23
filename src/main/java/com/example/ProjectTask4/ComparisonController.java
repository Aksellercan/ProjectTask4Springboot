package com.example.ProjectTask4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/compare")
public class ComparisonController {

    @Autowired
    private MainController mainController;

    @Autowired
    private Comparison comparisonService;

    // Fetch all smartphones to this controller
    @GetMapping
    public String showComparisonPage(Model model) {
        Iterable<SmartphoneDTO> smartphones = mainController.getAll(); //mainController.getAll() returns SmartphonesDTO type
        model.addAttribute("smartphones", smartphones);
        return "comparison";
    }

    //Choose what to compare
    @PostMapping
    public String comparePhones(
            @RequestParam long phone1Id,
            @RequestParam long phone2Id,
            @RequestParam String attribute,
            Model model) {

        Smartphone phone1 = mainController.getSmartphones(phone1Id);
        Smartphone phone2 = mainController.getSmartphones(phone2Id);

        String result = "";
        switch (attribute.toLowerCase()) {
            case "ram":
                result = comparisonService.Compare(phone1.getRam(), phone2.getRam(), phone1.getName(), phone2.getName(), "RAM");
                break;
            case "battery":
                result = comparisonService.Compare(phone1.getBatterysize(), phone2.getBatterysize(), phone1.getName(), phone2.getName(), "battery");
                break;
            case "screen":
                result = comparisonService.Compare(phone1.getScreensize(), phone2.getScreensize(), phone1.getName(), phone2.getName(), "screen size");
                break;
            case "storage":
                result = comparisonService.Compare(phone1.getStorage(), phone2.getStorage(), phone1.getName(), phone2.getName(), "storage");
                break;
            case "processor":
                result = comparisonService.Compare(phone1.getProcessorspeed(), phone2.getProcessorspeed(), phone1.getName(), phone2.getName(), "processor speed");
                break;
            default:
                result = "Invalid attribute selected";
        }

        model.addAttribute("result", result);
        model.addAttribute("smartphones", mainController.getAll());


        model.addAttribute("phone1", phone1); // Add phone 1 to the model
        model.addAttribute("phone2", phone2); // Add phone 2 to the model
        return "comparison";
    }
}
